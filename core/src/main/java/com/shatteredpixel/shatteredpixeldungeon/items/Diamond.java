package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;

public class Diamond extends Item {
    { image = 255; stackable = true; }
    @Override public String name() { return "алмаз"; }
    
    public static class Recipe extends Recipe.SimpleRecipe {
        {
            inputs = new Class[]{HardIron.class, Glass.class, PotionOfLiquidFlame.class};
            inQuantity = new int[]{1, 1, 1};
            output = Diamond.class;
            outQuantity = 1;
            cost = 10;
        }
    }
}
