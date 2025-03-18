package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.util.MMOUtils;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class ExplosionKnockbackResistance extends DoubleStat {
    public ExplosionKnockbackResistance() {
        super("EXPLOSION_KNOCKBACK_RESISTANCE",
                Material.OBSIDIAN,
                "爆炸击退抗性",
                "实体从爆炸中受到的击退影响系数。系数为1时完全移除击退效果，系数为0时表示没有击退减少");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
