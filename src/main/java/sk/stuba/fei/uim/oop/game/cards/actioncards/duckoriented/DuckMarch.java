package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;

public class DuckMarch extends ActionCard {

    @Override
    public void performAction(Pond pond) {
        pond.march();

    }

    @Override
    public String toString() {
        return "Duck march card";
    }
}
