package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class TurboDuck extends ActionCard {
    @Override
    public boolean performAction(Pond pond) {
        int chosenDuck = ZKlavesnice.readInt("Choose a duck to TURBO move ");
        if(chosenDuck >6 || chosenDuck<1){
            System.out.println("Both indexes must be between 1 to 6");
            return performAction(pond);

        }

        boolean successful = pond.moveDuck(chosenDuck, 1);
        if(!successful){
            System.out.println("You cant move water!");
            return performAction(pond);
        }else{
            System.out.println("Duck successfully moved from " + chosenDuck + " to 1");

        }
        return true;
    }

    @Override
    public String toString() {
        return "Turbo duck card";
    }
}
