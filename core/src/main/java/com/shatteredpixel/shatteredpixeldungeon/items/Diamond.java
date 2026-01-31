package com.shatteredpixel.shatteredpixeldungeon.items;

public class Diamond extends Item {
    {
        // Тот самый голубой кристалл, который ты нарисовал последним
        image = 255; 
        stackable = true;
    }

    @Override
    public String name() {
        return "алмаз";
    }

    @Override
    public String info() {
        return "Невероятно твердый и чистый драгоценный камень. " +
               "Его грани светятся внутренним светом, способным указать путь.";
    }

    @Override
    public int price() {
        return 300; // Твоя цена в магазине
    }
}
