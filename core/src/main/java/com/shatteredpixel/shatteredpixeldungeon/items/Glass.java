package com.shatteredpixel.shatteredpixeldungeon.items;

public class Glass extends Item {
    { image = 254; } 
    @Override public String name() { return "стекло"; }
    @Override public String info() { return "Чистое закаленное стекло."; }
    @Override public boolean isStackable() { return true; }
}
