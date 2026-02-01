package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

public class Saber extends MeleeWeapon {
    {
        image = 45;
        tier = 3;
    }

    @Override
    public String name() { return "Сабля"; }

    @Override
    public String desc() { return "Изогнутый клинок из легкой стали. Очень быстрый."; }

    @Override
    public int min() { return 10; }

    @Override
    public int max() { return 18; }
}
