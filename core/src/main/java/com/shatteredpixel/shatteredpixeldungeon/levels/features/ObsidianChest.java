package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.GglgogEye;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class ObsidianChest {
    public static void open( Hero hero, int pos ) {
        ObsidianKey key = hero.belongings.getItem( ObsidianKey.class );
        
        if (key != null) {
            // Удаляем ключ из рюкзака
            key.detach( hero.belongings.backpack ); 
            
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            Dungeon.observe(); 
            
            // Выбираем лут: Сабля или Глаз
            Item prize = Random.Int( 2 ) == 0 ? new Saber() : new GglgogEye();
            Dungeon.level.drop( prize, pos ).sprite.drop();
            
            GLog.p( "Обсидиановый замок поддался!" );
        } else {
            GLog.w( "Этот сундук требует обсидиановый ключ." );
        }
    }
}
