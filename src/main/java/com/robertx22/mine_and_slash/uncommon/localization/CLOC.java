package com.robertx22.mine_and_slash.uncommon.localization;

import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.util.text.TextFormatting;

public class CLOC {

    public static String translate(String s) {
        return MMORPG.proxy.translate(s);
    }

    private static String base(String s) {
		return MMORPG.proxy.translate(s);
	}

	public static String tooltip(String str) {

		return base(Ref.MODID + ".tooltip." + str);

	}

	public static String lore(String str) {

		return TextFormatting.GREEN + "'" + base(Ref.MODID + ".lore." + str) + "'";

	}

	public static String blank(String string) {

		return base(string);
	}

}
