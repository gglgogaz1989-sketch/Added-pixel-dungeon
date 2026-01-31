package com.shatteredpixel.shatteredpixeldungeon.items;

public class HardIron extends Item {
    { image = 13; } // Спрайт слитка
    @Override public String name() { return "твёрдое железо"; }
    @Override public String info() { return "Невероятно прочный металл. Из него можно выковать что-то легендарное."; }
    @Override public boolean isStackable() { return true; }
}

