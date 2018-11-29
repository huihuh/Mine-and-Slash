package com.robertx22.unique_items.bases;

import com.robertx22.customitems.gearitems.armor.ItemChest;
import com.robertx22.database.gearitemslots.Chest;
import com.robertx22.database.rarities.items.Unique;
import com.robertx22.unique_items.IUnique;

public abstract class BaseUniqueChest extends ItemChest implements IUnique {

    public BaseUniqueChest() {
	super(new Unique().Rank());
	IUnique.ITEMS.put(GUID(), this);

    }

    @Override
    public String slot() {
	return new Chest().Name();
    }

}
