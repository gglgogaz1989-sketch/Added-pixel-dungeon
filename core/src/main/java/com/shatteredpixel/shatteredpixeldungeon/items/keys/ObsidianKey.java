package com.shatteredpixel.shatteredpixeldungeon.items.keys;

public class ObsidianKey extends Key {
    
    {
        image = 58; // Твой индекс из items.png
    }

    @Override
    public String name() {
        return "Обсидиановый ключ";
    }

    @Override
    public String desc() {
        return "Этот тяжелый ключ высечен из вулканического стекла. Он идеально подходит к обсидиановым замкам.";
    }

    public ObsidianKey() {
        super();
    }
}

