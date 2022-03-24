package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;

import java.util.Collections;

public class Scatter extends ActionCard {// idk lepsi preklad ma nenapadol :D
                                        //edit, este som too stoopid aby som si vsimol ze readme je aj v anglictine

    @Override
    public boolean performAction(Pond pond) {
        System.out.println("The ducks are moving like crazy!");
        Collections.shuffle(pond.getPond());
        return true;
    }

    @Override
    public String toString() {
        return "Scatter card";
    }
}
