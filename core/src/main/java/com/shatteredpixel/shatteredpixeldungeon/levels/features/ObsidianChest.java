package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Saber;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class ObsidianChest extends Feature {
    
    // Это метод, который срабатывает, когда игрок нажимает на сундук
    @Override
    public void execute( Hero hero, int pos ) {
        // Проверяем, есть ли у героя обсидиановый ключ
        ObsidianKey key = hero.belongsTo.getItem( ObsidianKey.class );
        
        if (key != null) {
            key.detach( hero.belongsTo ); // Тратим ключ
            
            // "Ломаем" сундук (превращаем клетку в обычный пол)
            Dungeon.level.set( pos, Terrain.EMPTY_SP ); 
            Dungeon.level.updateVisuals( pos );
            
            // Выбрасываем награду (Саблю)
            Dungeon.level.drop( new Saber(), pos ).sprite.drop();
            
            GLog.p( "Обсидиановый сундук открыт!" );
        } else {
            GLog.w( "Этот сундук заперт на обсидиановый замок." );
        }
    }
}

