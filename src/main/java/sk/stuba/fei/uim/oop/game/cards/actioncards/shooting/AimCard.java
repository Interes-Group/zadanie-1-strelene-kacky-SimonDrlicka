package sk.stuba.fei.uim.oop.game.cards.actioncards.shooting;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class AimCard extends ActionCard {
    @Override
    public void performAction(Pond pond) {
        int index = ZKlavesnice.readInt("Where do you want to aim? Type number between 1 to 6");
        boolean successful = pond.addAimAt(index);
        if(!successful){
            performAction(pond);
        }
    }

    @Override
    public String toString() {
        return "Aim card";
    }
}
