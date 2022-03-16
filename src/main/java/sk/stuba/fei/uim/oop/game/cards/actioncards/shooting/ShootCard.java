package sk.stuba.fei.uim.oop.game.cards.actioncards.shooting;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class ShootCard extends ActionCard {
    @Override
    public void performAction(Pond pond) {
        int index = ZKlavesnice.readInt("Type index where you want to shoot 1-6");
        boolean successful = pond.shootAt(index);
        if(!successful){
            performAction(pond);
        }
    }

    @Override
    public String toString() {
        return "Shoot card";
    }
}
