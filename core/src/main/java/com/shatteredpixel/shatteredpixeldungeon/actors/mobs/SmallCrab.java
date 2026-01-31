package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.watabou.utils.Random;

public class SmallCrab extends Mob {

    {
        spriteClass = CrabSprite.class;
        
        HP = HT = 9;
        defenseSkill = 18;
        
        EXP = 3;
        maxLvl = 5;
        
        loot = MysteryMeat.class;
        lootChance = 0.3f;
    }

    @Override
    public String name() {
        return "малый краб";
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(1, 5);
    }

    @Override
    public int attackSkill(Char target) {
        return 10;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }
    
    // Вместо createSprite используем базовый метод появления, 
    // но БЕЗ super.createSprite(), чтобы не злить компилятор.
}
