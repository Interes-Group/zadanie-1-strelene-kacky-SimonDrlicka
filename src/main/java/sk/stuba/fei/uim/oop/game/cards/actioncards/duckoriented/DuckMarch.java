package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;

public class DuckMarch extends ActionCard {

    @Override
    public boolean performAction(Pond pond) {
        pond.march();
        return true;
    }

    @Override
    public String toString() {
        return "Duck march card";
    }
}
