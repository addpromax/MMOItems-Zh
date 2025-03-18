package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class WaterMovementEfficiency extends DoubleStat {
    public WaterMovementEfficiency() {
        super("WATER_MOVEMENT_EFFICIENCY",
                Material.WATER_BUCKET,
                "液体中移动效率",
                "被液体淹没时的移动速度系数。系数越高，越能减轻水下移动的惩罚。请注意，这仅代表淹没因素，其他因素（如未接触地面）也会影响。默认值和最小值为0，最大值为1。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
