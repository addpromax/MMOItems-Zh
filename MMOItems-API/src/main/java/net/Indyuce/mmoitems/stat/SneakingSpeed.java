package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class SneakingSpeed extends DoubleStat {
    public SneakingSpeed() {
        super("SNEAKING_SPEED",
                Material.LEATHER_BOOTS,
                "潜行移动速度",
                "潜行时的移动速度系数。系数为1表示潜行速度与行走速度相同，系数为0表示潜行时无法移动。默认值为0.3，最小值为0，最大值为1。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
