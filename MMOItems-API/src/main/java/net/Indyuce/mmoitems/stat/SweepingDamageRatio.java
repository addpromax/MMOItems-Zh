package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.stat.annotation.HasCategory;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import org.bukkit.Material;

@HasCategory(cat = "vanilla_attribute")
@VersionDependant(version = {1, 21})
public class SweepingDamageRatio extends DoubleStat {
    public SweepingDamageRatio() {
        super("SWEEPING_DAMAGE_RATIO",
                Material.LIGHT_GRAY_DYE,
                "横扫伤害比例",
                "在横扫攻击中，基础攻击伤害有多少会传递到次要目标。这是对横扫攻击基础伤害1的额外加成。值为0表示没有基础攻击伤害传递（横扫伤害为1），值为1表示所有基础攻击伤害都传递。默认值和最小值为0，最大值为1。");
    }

    @Override
    public double multiplyWhenDisplaying() {
        return 100;
    }
}
