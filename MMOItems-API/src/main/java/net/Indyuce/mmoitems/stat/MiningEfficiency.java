package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.util.MMOUtils;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class MiningEfficiency extends DoubleStat {
    public MiningEfficiency() {
        super("MINING_EFFICIENCY",
                Material.IRON_PICKAXE,
                "挖掘效率",
                "在使用高效挖掘方块的工具时，挖掘速度的增加系数。默认值和最小值为0，最大值为1024。"
        );
    }
}
