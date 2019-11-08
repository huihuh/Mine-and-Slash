package com.robertx22.mine_and_slash.config;

import net.minecraftforge.common.config.Config;

public class DmgParticleConfig {

    @Config.Name("")
	@Config.LangKey("mmorpg.config.floating_exp")
	@Config.Comment("")
	public boolean ENABLE_FLOATING_EXP = true;
	
	@Config.Name("")
	@Config.LangKey("mmorpg.config.floating_damage_numbers")
	@Config.Comment("")
	public boolean ENABLE_FLOATING_DMG = true;
	
	@Config.Name("")
	@Config.LangKey("mmorpg.config.floating_damage_numbers")
	@Config.Comment("")
	public boolean GROWS = true;
	
	@Config.Name("GRAVITY")
    @Config.LangKey("")
    @Config.Comment("")
    public float GRAVITY = 1;
	
	@Config.Name("START_SIZE")
    @Config.LangKey("")
    @Config.Comment("")
    public float START_SIZE = 1;
	
	@Config.Name("MAX_SIZE")
    @Config.LangKey("")
    @Config.Comment("")
    public float MAX_SIZE = 2;
	
	@Config.Name("LIFESPAN")
    @Config.LangKey("")
    @Config.Comment("")
    public float LIFESPAN = 12;
	
	@Config.Name("SPEED")
    @Config.LangKey("")
    @Config.Comment("")
    public float SPEED = 1;

}
