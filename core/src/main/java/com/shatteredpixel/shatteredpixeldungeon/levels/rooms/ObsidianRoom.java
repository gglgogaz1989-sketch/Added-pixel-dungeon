package com.shatteredpixel.shatteredpixeldungeon.levels.rooms;

import com.shatteredpixel.shatteredpixeldungeon.items.keys.ObsidianKey;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
// ВОТ ЭТИХ ИМПОРТОВ НЕ ХВАТАЛО:
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard.StandardRoom;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Door;

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
        // Рисуем стены и пол
        Painter.fill(level, this, Terrain.WALL, Terrain.EMPTY_SP);

        // Ставим сундук
        int center = level.pointToCell(center());
        level.set(center, Terrain.OBSIDIAN_CHEST);

        // Бросаем ключ
        int keyPos;
        do {
            keyPos = level.pointToCell(random());
        } while (keyPos == center);

        level.drop(new ObsidianKey(), keyPos).sprite.drop();

        // Запираем двери
        for (Door door : connected.values()) {
            door.set(Door.Type.LOCKED);
        }
    }
}
