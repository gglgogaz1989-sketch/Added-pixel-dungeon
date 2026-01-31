package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.watabou.utils.Random;

public class SmallCrab extends Mob {

    {
        spriteClass = CrabSprite.class;
        
        // Здоровье меньше, чем у обычного краба
        HP = HT = 9;
        
        // Чтобы шанс промаха по нему был ~20% на 1-м этаже,
        // defenseSkill должен быть около 18-20.
        defenseSkill = 18;
        
        // Опыт и максимальный уровень
        EXP = 3;
        maxLvl = 5;
        
        // Лут: Загадочное мясо с шансом 30%
        loot = MysteryMeat.class;
        lootChance = 0.3f;
    }

    @Override
    public String name() {
        return "малый краб";
    }

    @Override
    public int damageRoll() {
        // Урон 1-5
        return Random.NormalIntRange(1, 5);
    }

    @Override
    public int attackSkill(Char target) {
        // Меткость чуть ниже обычного краба
        return 10;
    }

    @Override
    public int drRoll() {
        // Сопротивление урону (броня)
        return Random.NormalIntRange(0, 2);
    }

    // Этот метод гарантирует, что спрайт будет маленьким без ошибок компиляции
    @Override
    public CharSprite createSprite() {
        CharSprite s = super.createSprite();
        s.scale.set( 0.7f ); // Уменьшаем до 70%
        return s;
    }
}
