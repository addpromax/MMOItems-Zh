package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class MovementEfficiency extends DoubleStat {
    public MovementEfficiency() {
        super("MOVEMENT_EFFICIENCY",
                Material.LEATHER_BOOTS,
                "移动效率",
                "实体在减缓移动的方块中移动的效率。系数为1时移除所有减速，系数为0时应用全部减速。默认值和最小值为0，最大值为1。"
        );
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
