package com.shatteredpixel.shatteredpixeldungeon.items.artifacts;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Light;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class GglgogEye extends Artifact {

    {
        name = "Глаз gglgog";
        image = 10; // ЗАМЕНИ на индекс своей текстуры!
    }

    protected boolean active = false;

    @Override
    protected ArtifactBuff makeBuff() {
        return new EyeBuff();
    }

    @Override
    public void execute(Hero hero) {
        if (charge < 100 && !active) {
            // Если не заряжен, ничего не делаем
            return;
        }
        
        active = !active; // Переключаем режим
        hero.sprite.emitter().burst( Light.Particle.class, 10 );
        updateQuickslot();
    }

    @Override
    public void onNextTurn() {
        if (active) {
            charge -= 1; // Уменьшаем заряд каждый ход
            if (charge <= 0) {
                charge = 0;
                active = false;
            }
        } else if (charge < 100) {
            charge += 0.5f; // Медленно заряжается сам, когда выключен
        }
    }

    // Бафф, который дает статы
    public class EyeBuff extends ArtifactBuff {
        @Override
        public boolean act() {
            if (active) {
                // Здесь будет логика подсветки врагов 3х3
            }
            return super.act();
        }
    }

    @Override
    public String desc() {
        return "Древний глаз, который видит всё. Увеличивает урон и обзор, " +
               "а при улучшении до +5 позволяет стрелять сквозь стены.";
    }
}

