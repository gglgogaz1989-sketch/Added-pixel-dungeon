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
        // 1. Заполняем комнату стенами по периметру и полом внутри
        Painter.fill(level, this, Terrain.WALL, Terrain.EMPTY_SP);

        // 2. Ставим сундук ровно по центру
        int center = level.pointToCell(center());
        level.set(center, Terrain.OBSIDIAN_CHEST);

        // 3. Ищем случайное место для ключа, чтобы он не упал ВНУТРЬ сундука
        int keyPos;
        do {
            // random() - встроенный метод комнаты, берет случайную точку внутри неё
            keyPos = level.pointToCell(random());
        } while (keyPos == center); // Если случайно попали в центр (сундук) — ищем снова

        // 4. Бросаем ключ
        level.drop(new ObsidianKey(), keyPos).sprite.drop();

        // 5. Запираем все двери
        for (Door door : connected.values()) {
            door.set(Door.Type.LOCKED);
        }
    }
}
