package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class ObsidianKey extends Item {

    {
        name = "Обсидиановый ключ";
        image = 58; // Твой индекс, который мы посчитали (Ряд 3, Колонка 10)
        stackable = true; // Можно носить несколько в одной ячейке
    }

    @Override
    public String desc() {
        return "Этот тяжелый ключ высечен из вулканического стекла. " +
               "Он кажется слишком хрупким для обычных дверей, но идеально подходит для обсидиановых замков.";
    }
    
    @Override
    public int price() {
        return 100;
    }
}

