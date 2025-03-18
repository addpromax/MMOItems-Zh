package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class OxygenBonus extends DoubleStat {
    public OxygenBonus() {
        super("OXYGEN_BONUS",
                Material.CONDUIT,
                "氧气消耗几率",
                "实体在水下不消耗氧气的几率系数。0无效果，值大于0时使用以下公式确定消耗氧气的几率：1 / (bonus_oxygen + 1)。最大值为1024");
    }
}
