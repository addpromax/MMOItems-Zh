package net.Indyuce.mmoitems.stat;

import net.Indyuce.mmoitems.api.item.build.ItemStackBuilder;
import net.Indyuce.mmoitems.api.item.mmoitem.ReadMMOItem;
import net.Indyuce.mmoitems.stat.annotation.VersionDependant;
import net.Indyuce.mmoitems.stat.data.StringData;
import net.Indyuce.mmoitems.stat.type.GemStoneStat;
import net.Indyuce.mmoitems.stat.type.StringStat;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@VersionDependant(version = {1, 21, 2})
public class ItemModel extends StringStat implements GemStoneStat {
    public ItemModel() {
        super("MODEL", Material.PAINTING, "Item Model",
                new String[]{"模型将用于渲染该项目。", "仅在 1.21.2+ 版本中可用"}, new String[0]);
    }

    @Override
    public void whenApplied(@NotNull ItemStackBuilder item, @NotNull StringData data) {
        item.getMeta().setItemModel(NamespacedKey.fromString(data.getString()));
    }

    @Override
    public void whenLoaded(@NotNull ReadMMOItem mmoitem) {
        ItemMeta meta = mmoitem.getNBT().getItem().getItemMeta();
        if (meta.hasItemModel()) mmoitem.setData(this, new StringData(meta.getItemModel().toString()));
    }
}
