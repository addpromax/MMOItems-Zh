package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.util.MMOUtils;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class BurningTime extends DoubleStat {
    public BurningTime() {
        super("BURNING_TIME",
                Material.FIRE_CHARGE,
                "点燃时间",
                "决定玩家被点燃后保持燃烧时间的系数。系数为0时完全移除燃烧时间，系数为1时实体燃烧默认时间，较大数值会延长实体的燃烧时间。默认值为1，最小值为0，最大值为1024。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
