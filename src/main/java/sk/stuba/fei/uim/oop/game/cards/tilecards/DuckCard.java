package sk.stuba.fei.uim.oop.game.cards.tilecards;

import sk.stuba.fei.uim.oop.game.ducks.Duck;
import sk.stuba.fei.uim.oop.game.player.Player;

public class DuckCard extends TileCard{

    public DuckCard(Player player){
        super(new Duck(player));
    }

    @Override
    public TileCard shoot() {
        duck.shoot();
        return this;
    }

    @Override
    public boolean removeAfterShooting() {
        return true;
    }

    @Override
    public String toString() {
        return duck.toString();
    }
}
