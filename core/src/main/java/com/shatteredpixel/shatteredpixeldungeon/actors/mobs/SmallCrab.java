package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.watabou.utils.Random;

public class SmallCrab extends Mob {

    {
        spriteClass = CrabSprite.class;
        
        HP = HT = 9;
        defenseSkill = 100;
        
        // Попробуем прописать опыт напрямую в переменную, 
        // так как метод exp() у тебя не переопределяется
        exp = 3;
    }

    @Override
    public String name() {
        return "малый краб";
    }

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

    // Если переменная exp выше выдаст ошибку, используй этот способ без @Override
    // Но пока оставляем как переменную.

    @Override
    public void spawn( int pos ) {
        super.spawn( pos );
        // Если scale не сработает, краб просто будет обычного размера, 
        // но игра НЕ вылетит
        if (sprite != null) {
            sprite.scale.set( 0.7f );
        }
    }

    public static float spawnChance() {
        return 0.2f;
    }
}
