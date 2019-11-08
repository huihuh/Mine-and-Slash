package com.robertx22.mine_and_slash.onevent.player;

import com.robertx22.mine_and_slash.database.gearitemslots.baubles.Bracelet;
import com.robertx22.mine_and_slash.database.gearitemslots.baubles.Necklace;
import com.robertx22.mine_and_slash.database.gearitemslots.baubles.Ring;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateChest;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlatePants;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Sword;
import com.robertx22.mine_and_slash.database.spells.self.SpellInstantHeal;
import com.robertx22.mine_and_slash.items.ores.ItemOre;
import com.robertx22.mine_and_slash.loot.blueprints.GearBlueprint;
import com.robertx22.mine_and_slash.loot.blueprints.MapBlueprint;
import com.robertx22.mine_and_slash.loot.blueprints.SpellBlueprint;
import com.robertx22.mine_and_slash.loot.gens.GearLootGen;
import com.robertx22.mine_and_slash.loot.gens.MapLootGen;
import com.robertx22.mine_and_slash.loot.gens.SpellLootGen;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.mmorpg.registers.common.BlockRegister;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.localization.Chats;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnLogin {

    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {

        if (event.getPlayer().world.isRemote) {
            return;
        }

        try {

        	EntityPlayer player = event.getPlayer();

            if (Load.hasUnit(player)) {

                UnitData data = Load.Unit(player);

                data.onLogin(player);

                data.syncToClient(player);

                Load.playerMapData(player).teleportPlayerBack(player);

            } else {
                player.sendMessage(new ITextComponent("Error, player has no capability!" + Ref.MOD_NAME + " mod is broken!"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void GiveStarterItems(EntityPlayer player) {

        GearBlueprint print = new GearBlueprint(1);
        print.SetSpecificType(Sword.INSTANCE.GUID());
        print.LevelRange = false;
        print.setSpecificRarity(0);

        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(PlatePants.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(PlateChest.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(PlateHelmet.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(PlateBoots.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));

        print.SetSpecificType(Ring.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(Ring.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(Necklace.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));
        print.SetSpecificType(Bracelet.INSTANCE.GUID());
        player.inventory.addItemStackToInventory(GearLootGen.CreateStack(print));

        SpellBlueprint spell = new SpellBlueprint(1);
        spell.SetSpecificType(new SpellInstantHeal().GUID());
        spell.LevelRange = false;
        spell.setSpecificRarity(0);

        player.inventory.addItemStackToInventory(new ItemStack(ItemOre.ItemOres.get(0)));

        player.inventory.addItemStackToInventory(SpellLootGen.Create(spell));
    }

}
