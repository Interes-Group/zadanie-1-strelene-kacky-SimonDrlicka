package sk.stuba.fei.uim.oop.game.cards.tilecards;

import sk.stuba.fei.uim.oop.game.cards.Card;
import sk.stuba.fei.uim.oop.game.ducks.Duck;

public abstract class TileCard extends Card {
    protected Duck duck;

    public TileCard(Duck duck){
        this.duck = duck;
    }
    public abstract TileCard shoot();
    public abstract boolean removeAfterShooting();
    //Getters
    public Duck getDuck() {
        return duck;
    }

}
