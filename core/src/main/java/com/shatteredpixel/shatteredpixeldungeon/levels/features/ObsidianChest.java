package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class ObsidianChest {

    public static void open( Hero hero, int pos ) {
        // Проверяем наличие обсидианового ключа в инвентаре
        ObsidianKey key = hero.belongings.getItem( ObsidianKey.class );
        
        if (key != null) {
            // Удаляем ключ
            key.detach( hero.belongings ); 
            
            // Превращаем сундук в пустой пол (Terrain.EMPTY_SP)
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            Dungeon.observe(); // Обновляем графику уровня
            
            // Выбрасываем саблю на пол
            Dungeon.level.drop( new Saber(), pos ).sprite.drop();
            
            GLog.p( "Обсидиановый замок щелкнул и открылся!" );
        } else {
            // Если ключа нет
            GLog.w( "Вам нужен обсидиановый ключ, чтобы открыть этот сундук." );
        }
    }
}
