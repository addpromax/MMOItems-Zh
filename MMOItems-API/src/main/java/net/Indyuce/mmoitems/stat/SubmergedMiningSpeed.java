package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class SubmergedMiningSpeed extends DoubleStat {
    public SubmergedMiningSpeed() {
        super("SUBMERGED_MINING_SPEED",
                Material.WATER_BUCKET,
                "液体中挖掘速度",
                "被液体淹没时的挖掘速度系数。系数为1表示淹没时的挖掘速度与在陆地上一样快，系数为0表示淹没时无法挖掘。请注意，这仅代表淹没因素，其他因素（如未接触地面）也会影响。默认值为0.2，最小值为0，最大值为20。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
