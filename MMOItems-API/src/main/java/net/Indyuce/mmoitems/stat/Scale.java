package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 20, 5})
public class Scale extends DoubleStat {
    public Scale() {
        super("SCALE",
                Material.STONE,
                "尺寸",
                "允许将玩家的大小更改为默认大小的0.0625倍到16倍之间。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
