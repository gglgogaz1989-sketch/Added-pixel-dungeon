package com.shatteredpixel.shatteredpixeldungeon.items;

public class Bottle extends Item {
    { image = 253; }
    @Override public String name() { return "пустая бутылка"; }
    @Override public String info() { return "Прозрачный сосуд для жидкостей."; }
    @Override public boolean isStackable() { return true; }
}
