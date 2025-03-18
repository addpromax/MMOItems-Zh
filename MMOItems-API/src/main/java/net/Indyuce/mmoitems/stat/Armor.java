package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
public class Armor extends DoubleStat {
    public Armor() {
        super("ARMOR",
                Material.GOLDEN_CHESTPLATE,
                "盔甲值",
                "给予持有者的护甲值。");
    }
}
