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
        // 1. Рисуем коробку комнаты
        Painter.fill(level, this, Terrain.WALL, Terrain.EMPTY_SP);

        // 2. Ставим сундук в центр
        int center = level.pointToCell(center());
        level.set(center, Terrain.OBSIDIAN_CHEST);

        // 3. Гарантированно спавним ключ где-то на этаже
        // Мы используем randomRespawnCell, чтобы ключ не упал в стену
        int keyPos = level.randomRespawnCell();
        if (keyPos != -1) {
            level.drop(new ObsidianKey(), keyPos).sprite.drop();
        }

        // 4. Запираем вход на обычный железный замок (белый)
        for (Door door : connected.values()) {
            door.set(level, Door.Type.LOCKED);
        }
    }
}

