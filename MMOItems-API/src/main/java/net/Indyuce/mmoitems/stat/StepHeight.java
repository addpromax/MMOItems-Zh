package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 20, 5})
public class StepHeight extends DoubleStat {
    public StepHeight() {
        super("STEP_HEIGHT",
                Material.STONE_SLAB,
                "Step Height",
                "决定生物无需跳跃即可越过的最大方块高度。默认值为0.6，合法范围是0到10。");
    }
}
