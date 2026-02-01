package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class ObsidianChest {

    public static void open( Hero hero, int pos ) {
        // Ищем ключ в рюкзаке
        ObsidianKey key = hero.belongings.getItem( ObsidianKey.class );
        
        if (key != null) {
            // Исправленный метод удаления: используем принадлежность предмета
            key.detach( key.belongsTo ); 
            
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            Dungeon.observe(); 
            
            Dungeon.level.drop( new Saber(), pos ).sprite.drop();
            GLog.p( "Обсидиановый замок щелкнул и открылся!" );
        } else {
            GLog.w( "Этот сундук заперт на обсидиановый замок." );
        }
    }
}
