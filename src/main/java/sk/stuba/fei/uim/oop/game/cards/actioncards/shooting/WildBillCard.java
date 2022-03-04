package sk.stuba.fei.uim.oop.game.cards.actioncards.shooting;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBillCard extends ActionCard {
    @Override
    public void performAction(Pond pond) {
        int choice = ZKlavesnice.readInt("Type where you want to shoot (1-6 inclusive)");
        pond.addAimAt(choice);
        boolean successful = pond.shootAt(choice);
        if(!successful){
            performAction(pond);
        }else{
            pond.addToTrash(this);
        }
    }

    @Override
    public String toString() {
        return "Wild Bill card";
    }
}
