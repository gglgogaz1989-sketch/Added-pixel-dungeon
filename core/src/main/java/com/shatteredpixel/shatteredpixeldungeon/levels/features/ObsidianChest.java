package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class ObsidianChest {
    public static void open( Hero hero, int pos ) {
        ObsidianKey key = hero.belongings.getItem( ObsidianKey.class );
        
        if (key != null) {
            // В новых версиях ключ удаляется через рюкзак напрямую
            hero.belongings.backpack.remove( key ); 
            
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            Dungeon.observe(); 
            
            Dungeon.level.drop( new Saber(), pos ).sprite.drop();
            GLog.p( "Обсидиановый замок открылся!" );
        } else {
            GLog.w( "Нужен обсидиановый ключ!" );
        }
    }
}
