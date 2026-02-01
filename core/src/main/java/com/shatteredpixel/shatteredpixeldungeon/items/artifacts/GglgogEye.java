package com.shatteredpixel.shatteredpixeldungeon.items.artifacts;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

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

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        if (isEquipped(hero)) {
            actions.add("ИСПОЛЬЗОВАТЬ");
        }
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        if (action.equals("ИСПОЛЬЗОВАТЬ")) {
            for (Mob mob : Dungeon.level.mobs) {
                if (mob != null && mob.isAlive()) {
                    // ИСПРАВЛЕНИЕ: Просто делаем видимым, убрали updateArmor()
                    mob.sprite.visible = true;
                }
            }
            // Тратим ход и показываем сообщение
            hero.spend(1f);
            hero.sprite.operate(hero.pos);
            GLog.p("Ваш взор пронзает тьму...");
        } else {
            super.execute(hero, action);
        }
    }
}
