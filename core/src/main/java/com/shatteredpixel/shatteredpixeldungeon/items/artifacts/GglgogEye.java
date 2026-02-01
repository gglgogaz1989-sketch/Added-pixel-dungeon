package com.shatteredpixel.shatteredpixeldungeon.items.artifacts;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class GglgogEye extends Artifact {

    {
        image = 59;
    }

    @Override
    public String name() {
        return "Глаз gglgog";
    }

    @Override
    public String desc() {
        return "Этот жуткий глаз всё еще вращается в глазнице. При активации он позволяет увидеть жизненную энергию всех существ на этаже.";
    }

    // Добавляем действие "Активировать" в меню предмета
    @Override
    public java.util.ArrayList<String> actions(com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero hero) {
        java.util.ArrayList<String> actions = super.actions(hero);
        if (isEquipped(hero)) {
            actions.add("ИСПОЛЬЗОВАТЬ");
        }
        return actions;
    }

    @Override
    public void execute(com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero hero, String action) {
        if (action.equals("ИСПОЛЬЗОВАТЬ")) {
            
            activateVision();
            
            // Расходуем ход
            hero.spend(1f);
            hero.busy();
            hero.sprite.operate(hero.pos);
            
            GLog.p("Глаз gglgog широко открывается...");
        } else {
            super.execute(hero, action);
        }
    }

    private void activateVision() {
        // Проходим по всем мобам на текущем уровне
        for (Mob mob : Dungeon.level.mobs) {
            if (mob != null && mob.isAlive()) {
                // Делаем моба видимым для игрока (даже сквозь стены)
                mob.sprite.visible = true;
                // В некоторых версиях нужно обновить освещение спрайта
                mob.sprite.updateArmor(); 
            }
        }
    }
}
