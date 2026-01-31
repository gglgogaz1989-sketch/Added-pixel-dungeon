package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.alchemy.AlchemicalRecipe;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;

public class Diamond extends Item {
    {
        image = 255;
        stackable = true;
    }

    @Override
    public String name() { return "алмаз"; }

    // Пробуем прописать рецепт прямо тут (для версии 3.0+)
    public AlchemicalRecipe recipe() {
        return new AlchemicalRecipe(this, 10, HardIron.class, Glass.class, PotionOfLiquidFlame.class);
    }

    public int price() { return 300; }
}
