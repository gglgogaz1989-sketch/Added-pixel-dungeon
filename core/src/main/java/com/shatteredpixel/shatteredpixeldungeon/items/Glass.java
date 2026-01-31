package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;

public class Glass extends Item {
    { image = 254; stackable = true; }
    @Override public String name() { return "стекло"; }

    // Переименовали в GlassRecipe и указали полный путь к родителю
    public static class GlassRecipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {
        {
            inputs = new Class[]{PotionOfLiquidFlame.class, Bottle.class};
            inQuantity = new int[]{1, 1};
            output = Glass.class;
            outQuantity = 1;
            cost = 2;
        }
    }
}
