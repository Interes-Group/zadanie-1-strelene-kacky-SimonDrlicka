package sk.stuba.fei.uim.oop.game.cards.actioncards.shooting;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class AimCard extends ActionCard {
    @Override
    public boolean performAction(Pond pond) {
        if(!pond.canAim()){
            System.out.println("You can't use this card right now, choose another one.");
            return false;
        }
        int index = ZKlavesnice.readInt("Where do you want to aim? Type number between 1 to 6");
        boolean successful = pond.addAimAt(index);
        if(!successful){
            return performAction(pond);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aim card";
    }
}
