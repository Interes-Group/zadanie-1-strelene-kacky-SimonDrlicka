package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;

public class DuckDance extends ActionCard {
    @Override
    public boolean performAction(Pond pond) {
        System.out.println("The ducks are dancin'..");
        pond.dance();
        return true;
    }

    @Override
    public String toString() {
        return "Duck dance card";
    }
}
