package com.shatteredpixel.shatteredpixeldungeon.items;

public class Diamond extends Item {
    {
        image = 255;
        stackable = true;
    }

    @Override
    public String name() { 
        return "алмаз"; 
    }

    @Override
    public String info() { 
        return "Невероятно твердый и чистый драгоценный камень."; 
    }

    public int price() { 
        return 300; 
    }
}
