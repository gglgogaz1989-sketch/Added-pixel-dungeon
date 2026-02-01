package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

// Если Feature не находится, попробуй заменить на Level.Feature или просто убрать extends, если это тайл
public class ObsidianChest { 
    
    public static void open( Hero hero, int pos ) {
        // Проверка ключа через инвентарь (в Shattered это обычно hero.belongings.getItem)
        ObsidianKey key = hero.belongings.getItem( ObsidianKey.class );
        
        if (key != null) {
            key.detach( hero.belongings ); 
            
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            // В новых версиях вместо updateVisuals используется:
            Dungeon.observe(); 
            
            Dungeon.level.drop( new Saber(), pos ).sprite.drop();
            GLog.p( "Обсидиановый сундук открыт!" );
        } else {
            GLog.w( "Этот сундук заперт на обсидиановый замок." );
        }
    }
}
