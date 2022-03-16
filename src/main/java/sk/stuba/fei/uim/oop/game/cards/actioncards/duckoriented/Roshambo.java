package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;

import java.util.Collections;

public class Roshambo extends ActionCard {// idk lepsi preklad ma nenapadol :D

    @Override
    public void performAction(Pond pond) {
        System.out.println("The ducks are moving like crazy!");
        Collections.shuffle(pond.getPond());

    }

    @Override
    public String toString() {
        return "Roshambo card";
    }
}
