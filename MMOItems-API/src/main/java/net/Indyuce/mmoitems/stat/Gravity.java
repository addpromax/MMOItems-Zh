package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 20, 5})
public class Gravity extends DoubleStat {
    public Gravity() {
        super("GRAVITY",
                Material.STONE,
                "重力",
                "增加重力。默认值为1");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
