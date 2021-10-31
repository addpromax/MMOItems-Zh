package net.Indyuce.mmoitems.api.interaction.weapon.untargeted.lute;

import com.google.gson.JsonObject;
import io.lumine.mythic.lib.MythicLib;
import io.lumine.mythic.lib.api.item.NBTItem;
import io.lumine.mythic.lib.comp.target.InteractionType;
import io.lumine.mythic.lib.damage.DamageMetadata;
import io.lumine.mythic.lib.damage.DamageType;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.MMOUtils;
import io.lumine.mythic.lib.damage.AttackMetadata;
import net.Indyuce.mmoitems.api.ItemAttackMetadata;
import net.Indyuce.mmoitems.api.util.SoundReader;
import net.Indyuce.mmoitems.stat.data.ProjectileParticlesData;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

public class SimpleLuteAttack implements LuteAttackHandler {

	@Override
	public void handle(ItemAttackMetadata attack, NBTItem nbt, double attackDamage, double range, Vector weight, SoundReader sound) {
		new BukkitRunnable() {
			final Vector vec = attack.getPlayer().getEyeLocation().getDirection().multiply(.4);
			final Location loc = attack.getPlayer().getEyeLocation();
			int ti = 0;

			public void run() {
				if (ti++ > range) cancel();

				List<Entity> entities = MMOUtils.getNearbyChunkEntities(loc);
				for (int j = 0; j < 3; j++) {
					loc.add(vec.add(weight));
					if (loc.getBlock().getType().isSolid()) {
						cancel();
						break;
					}

					if (nbt.hasTag("MMOITEMS_PROJECTILE_PARTICLES")) {
						JsonObject obj = MythicLib.plugin.getJson().parse(nbt.getString("MMOITEMS_PROJECTILE_PARTICLES"), JsonObject.class);
						Particle particle = Particle.valueOf(obj.get("Particle").getAsString());
						// If the selected particle is colored, use the provided color
						if (ProjectileParticlesData.isColorable(particle)) {
							double red = Double.parseDouble(String.valueOf(obj.get("Red")));
							double green = Double.parseDouble(String.valueOf(obj.get("Green")));
							double blue = Double.parseDouble(String.valueOf(obj.get("Blue")));
							ProjectileParticlesData.shootParticle(attack.getPlayer(), particle, loc, red, green, blue);
							// If it's not colored, just shoot the particle
						} else {
							ProjectileParticlesData.shootParticle(attack.getPlayer(), particle, loc, 0, 0, 0);
						}
						// If no particle has been provided via projectile particle attribute, default to this particle
					} else {
						loc.getWorld().spawnParticle(Particle.NOTE, loc, 0);
					}

					if (j == 0) sound.play(loc, 2, (float) (.5 + (double) ti / range));

					for (Entity target : entities)
						if (MMOUtils.canTarget(attack.getPlayer(), loc, target, InteractionType.OFFENSE_ACTION)) {
							new ItemAttackMetadata(new DamageMetadata(attackDamage, DamageType.WEAPON, DamageType.PROJECTILE), attack.getStats()).applyEffectsAndDamage(nbt, (LivingEntity) target);
							cancel();
							return;
						}
				}
			}
		}.runTaskTimer(MMOItems.plugin, 0, 1);
	}
}

