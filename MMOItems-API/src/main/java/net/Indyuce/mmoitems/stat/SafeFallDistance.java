package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 20, 5})
public class SafeFallDistance extends DoubleStat {
    public SafeFallDistance() {
        super("SAFE_FALL_DISTANCE",
                Material.RED_BED,
                "摔落高度",
                "控制玩家受到摔落伤害的距离。默认值为3，合法范围是-1024到+1024。");
    }
}
