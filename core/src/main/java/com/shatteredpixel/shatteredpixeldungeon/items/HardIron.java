package com.shatteredpixel.shatteredpixeldungeon.items;

public class HardIron extends Item {
    {
        image = 13;
        stackable = true; // Убрали @Override, сделали через переменную
    }

    @Override
    public String name() { return "твёрдое железо"; }
}
