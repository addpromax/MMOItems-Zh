package net.Indyuce.mmoitems.stat.data.random;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.ConfigurationSection;

import net.Indyuce.mmoitems.api.itemgen.GeneratedItemBuilder;
import net.Indyuce.mmoitems.api.itemgen.RandomStatData;
import net.Indyuce.mmoitems.stat.data.PotionEffectListData;
import net.Indyuce.mmoitems.stat.data.type.StatData;

public class RandomPotionEffectListData implements RandomStatData {
	private final List<RandomPotionEffectData> effects = new ArrayList<>();

	public RandomPotionEffectListData(ConfigurationSection config) {
		Validate.notNull(config, "Config cannot be null");

		for (String key : config.getKeys(false))
			this.effects.add(new RandomPotionEffectData(config.getConfigurationSection(key)));
	}

	public RandomPotionEffectListData(RandomPotionEffectData... effects) {
		add(effects);
	}

	public void add(RandomPotionEffectData... effects) {
		for (RandomPotionEffectData effect : effects)
			this.effects.add(effect);
	}

	public List<RandomPotionEffectData> getEffects() {
		return effects;
	}

	@Override
	public StatData randomize(GeneratedItemBuilder builder) {
		PotionEffectListData list = new PotionEffectListData();
		effects.forEach(random -> list.add(random.randomize(builder)));
		return list;
	}
}