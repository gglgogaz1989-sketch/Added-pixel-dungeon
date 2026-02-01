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

        // ИСПРАВЛЕНИЕ 1: Убрали Terrain.EMPTY_SP из скобок.
        // Метод сам найдет подходящую клетку.
        int keyPos = level.randomRespawnCell(); 
        
        if (keyPos != -1) {
            level.drop(new ObsidianKey(), keyPos).sprite.drop();
        }

        // ИСПРАВЛЕНИЕ 2: Оставили только тип двери.
        // Дверь сама знает свои координаты.
        for (Door door : connected.values()) {
            door.set(Door.Type.LOCKED); 
        }
    }
}
