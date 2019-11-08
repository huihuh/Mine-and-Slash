package com.robertx22.mine_and_slash.config;

import com.robertx22.mine_and_slash.a_libraries.neat_mob_overlay.NeatConfig;
import com.robertx22.mine_and_slash.uncommon.enumclasses.PlayerGUIs;

import net.minecraftforge.common.config.Config;

import org.apache.commons.lang3.tuple.Pair;

public class ClientContainer {

	@Config.Name("Show Affixes In Item Names")
	@Config.LangKey("")
	@Config.Comment("")
	public boolean SHOW_AFFIXED_NAME = true;
	
	@Config.Name("Render Mob Health Bar")
	@Config.LangKey("mmorpg.config.mob_health_bag")
	@Config.Comment("Show/Disable mob health bars")
	public boolean RENDER_MOB_HEALTH_GUI = true;
	
	@Config.Name("Show Low Ene/Mana Warnings")
	@Config.LangKey("mmorpg.config.low_resource_warnings")
	@Config.Comment("Posts them in chat if you can't cast spell or attakc")
	public boolean SHOW_LOW_ENERGY_MANA_WARNING = false;
	
	@Config.Name("Auto Enable EB Wizadry Item Stats")
	@Config.LangKey("mmorpg.config.")
	@Config.Comment("This enables auto adding stats to items from EB Wizardry")
	public boolean SHOW_VANILLA_HEARTS = true;
	
	@Config.Name("Show Unmet Gear Requirments")
	@Config.LangKey("")
	@Config.Comment("")
	public boolean SHOW_UNMET_GEAR_REQUIREMENTS_GUI = true;
	
	@Config.Name("Player Gui Overlay Type")
	@Config.LangKey("mmorpg.config.player_gui_overlay_type")
	@Config.Comment("Choose different Gui styles for hp mana etc overlay")
	public PlayerGUIs PLAYER_GUI_TYPE = PlayerGUIs.Bottom_Middle_Corners;


}
