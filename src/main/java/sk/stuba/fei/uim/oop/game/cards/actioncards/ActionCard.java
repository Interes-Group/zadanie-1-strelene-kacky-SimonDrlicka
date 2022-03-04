package sk.stuba.fei.uim.oop.game.cards.actioncards;

import sk.stuba.fei.uim.oop.game.cards.Card;
import sk.stuba.fei.uim.oop.game.pond.Pond;

public abstract class ActionCard extends Card {
    public abstract void performAction(Pond pond);
}
