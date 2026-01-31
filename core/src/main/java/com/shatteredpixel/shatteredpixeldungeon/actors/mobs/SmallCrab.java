package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.watabou.utils.Random;

public class SmallCrab extends Mob {

	{
		spriteClass = CrabSprite.class;
		
		// Твои параметры: HP 9
		HP = HT = 9;
		
		// Огромная защита для промахов
		defenseSkill = 100;
		
		// Опыт как в твоем примере
		EXP = 3;
		maxLvl = 5;
	}

	@Override
	public String name() {
		return "малый краб";
	}
	
	@Override
	public int damageRoll() {
		// Твой урон 1-5
		return Random.NormalIntRange( 1, 5 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 10;
	}
	
	@Override
	public int drRoll() {
		// Базовая броня (Damage Reduction)
		return Random.NormalIntRange(0, 2);
	}
}
