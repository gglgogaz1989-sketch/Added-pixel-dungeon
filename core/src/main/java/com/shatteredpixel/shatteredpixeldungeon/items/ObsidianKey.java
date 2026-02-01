package com.shatteredpixel.shatteredpixeldungeon.items;

public class ObsidianKey extends Item {
    {
        // Имя в коде задается так, если нет ресурсов:
        image = 58; 
    }

    @Override
    public String Name() {
        return "Обсидиановый ключ";
    }

    @Override
    public String info() {
        return "Этот тяжелый ключ высечен из вулканического стекла. Идеально подходит для обсидиановых замков.";
    }

    @Override
    public int price() {
        return 100;
    }
}
