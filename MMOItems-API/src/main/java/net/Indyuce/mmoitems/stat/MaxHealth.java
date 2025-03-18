package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
public class MaxHealth extends DoubleStat {
    public MaxHealth() {
        super("MAX_HEALTH",
                Material.GOLDEN_APPLE,
                "最大给予生命值",
                "此物品给予持有者的生命值。");
    }
}
