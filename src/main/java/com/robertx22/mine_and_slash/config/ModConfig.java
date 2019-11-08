package com.robertx22.mine_and_slash.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import com.robertx22.mine_and_slash.a_libraries.neat_mob_overlay.NeatConfig;
import com.robertx22.mine_and_slash.mmorpg.Ref;

@Config(modid = Ref.MODID)
@Config.LangKey("mmorpg.config.title")
@EventBusSubscriber
public class ModConfig {

	@Config.Name("Client")
    @Config.LangKey("mmorpg.config.client")
    public static ClientContainer Client = new ClientContainer();
	
	@Config.Name("Rarity Weights")
    @Config.LangKey("mmorpg.config.rarity_weights")
    public static RarityDropratesConfig RarityWeightConfig = new RarityDropratesConfig();
	
	@Config.Name("Droprates")
    @Config.LangKey("mmorpg.config.droprates")
    public static DropRatesContainer DropRates = new DropRatesContainer();
	
	@Config.Name("Server")
    @Config.LangKey("mmorpg.config.server")
    public static ServerContainer Server = new ServerContainer();
	
	@Config.Name("Base Player Stats")
    @Config.LangKey("mmorpg.word.base_player_stats")
    @Config.Comment("Be careful! Some Stats don't scale with levels so they shouldn't have any per level bonuses. You can still do it but you've been warned!")
    public static StatConfig PlayerBaseStats = new StatConfig();
	
	@Config.Name("Neat Config")
	@Config.LangKey("")
	@Config.Comment("")
	public static NeatConfig neatConfig = new NeatConfig();
	
	@Config.Name("Neat Config")
	@Config.LangKey("")
	@Config.Comment("")
	public static DmgParticleConfig dmgParticleConfig  = new DmgParticleConfig();;

}
