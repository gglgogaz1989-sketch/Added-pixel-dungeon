package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.watabou.utils.Random;

public class SmallCrab extends Mob {

    {
        // В новых версиях имя берется из ресурсов, 
        // но для мода можно задать так:
        spriteClass = CrabSprite.class;
        
        HP = HT = 9;
        defenseSkill = 100;
        
        // В новых версиях опыт задается через метод или так:
        HT = HP = 9;
    }

    // Правильный способ задать имя в коде
    @Override
    public String name() {
        return "малый краб";
    }

    // Правильный способ задать опыт
    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange( 1, 5 );
    }

    @Override
    public int attackSkill( Char target ) {
        return 10;
    }

    // Заменяем сломанный exp = 3
    @Override
    public int exp() {
        return 3;
    }

    // Исправляем ошибку со spawn(pos)
    @Override
    public void onSpawn() {
        super.onSpawn();
        if (sprite != null) {
            sprite.scale.set( 0.7f );
        }
    }

    public static float spawnChance() {
        return 0.2f;
    }
}
