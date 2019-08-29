package net.Indyuce.mmoitems.api.interaction.weapon.untargeted.staff;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import net.Indyuce.mmoitems.MMOUtils;
import net.Indyuce.mmoitems.api.AttackResult;
import net.Indyuce.mmoitems.api.DamageInfo.DamageType;
import net.Indyuce.mmoitems.api.interaction.weapon.untargeted.UntargetedWeapon;
import net.Indyuce.mmoitems.api.item.NBTItem;
import net.Indyuce.mmoitems.api.player.PlayerStats.TemporaryStats;
import net.Indyuce.mmoitems.version.VersionSound;

public class LightningSpirit implements StaffAttackHandler {

	@Override
	public void handle(TemporaryStats stats, NBTItem nbt, double attackDamage, double range, UntargetedWeapon untargeted) {
		stats.getPlayer().getWorld().playSound(stats.getPlayer().getLocation(), VersionSound.ENTITY_FIREWORK_ROCKET_BLAST.toSound(), 2, 2);
		Location loc = stats.getPlayer().getEyeLocation();
		Vector vec = stats.getPlayer().getEyeLocation().getDirection().multiply(.75);
		for (int j = 0; j < range; j++) {
			loc.add(vec);
			if (loc.getBlock().getType().isSolid())
				break;

			loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc, 0);
			for (Entity target : MMOUtils.getNearbyChunkEntities(loc))
				if (MMOUtils.canDamage(stats.getPlayer(), loc, target)) {
					new AttackResult(untargeted, attackDamage).applyEffectsAndDamage(stats, nbt, (LivingEntity) target, DamageType.WEAPON, DamageType.PROJECTILE);
					loc.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 16, 0, 0, 0, .1);
					return;
				}
		}
	}
}
