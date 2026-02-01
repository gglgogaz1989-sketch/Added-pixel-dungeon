package com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard;

import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class ObsidianRoom extends StandardRoom {

    @Override
    public int minWidth() { return 5; }
    @Override
    public int maxWidth() { return 5; }
    @Override
    public int minHeight() { return 5; }
    @Override
    public int maxHeight() { return 5; }

    @Override
    public void paint(Level level) {
        Painter.fill(level, this, Terrain.WALL, Terrain.EMPTY_SP);

        int center = level.pointToCell(center());
        level.set(center, Terrain.OBSIDIAN_CHEST);

        // В новых версиях нужно указывать, на какой тип пола класть предмет
        int keyPos = level.randomRespawnCell( Terrain.EMPTY_SP );
        if (keyPos != -1) {
            level.drop(new ObsidianKey(), keyPos).sprite.drop();
        }

        for (Door door : connected.values()) {
            // Исправленные аргументы: уровень, позиция двери, тип
            door.set(level, level.pointToCell(door), Door.Type.LOCKED);
        }
    }
}
