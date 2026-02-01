package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Saber extends MeleeWeapon {

    {
        // Название для логов
        image = 45; // Замени на свой индекс сабли в items.png
        tier = 3;   // Уровень оружия (как у меча)
    }

    @Override
    public String Name() {
        return "Сабля";
    }

    @Override
    public String info() {
        return "Изогнутый клинок, выкованный из легкой, но прочной стали. Позволяет наносить быстрые и точные удары.";
    }

    @Override
    public int min() {
        return 10; // Минимальный урон
    }

    @Override
    public int max() {
        return 18; // Максимальный урон
    }
    
    @Override
    public int price() {
        return 150;
    }
}

