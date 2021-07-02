package net.hyper_pigeon.better_wandering_trader;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class BetterWanderingTraderMod implements ModInitializer {

	//public static BetterWanderingTraderConfig config = AutoConfig.getConfigHolder(BetterWanderingTraderConfig.class).getConfig();
	public static BetterWanderingTraderConfig CONFIG = AutoConfig.register(BetterWanderingTraderConfig.class, JanksonConfigSerializer::new)
			.getConfig();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//AutoConfig.register(BetterWanderingTraderConfig.class, JanksonConfigSerializer::new);
		//config = AutoConfig.getConfigHolder(BetterWanderingTraderConfig.class).getConfig();
		//BetterWanderingTraderConfig config = AutoConfig.getConfigHolder(BetterWanderingTraderConfig.class).getConfig();
		//System.out.println("Hello Fabric world!");
	}




}
