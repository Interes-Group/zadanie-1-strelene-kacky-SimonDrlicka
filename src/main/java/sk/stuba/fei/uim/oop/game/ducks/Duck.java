package sk.stuba.fei.uim.oop.game.ducks;

import sk.stuba.fei.uim.oop.game.player.Player;

public class Duck {// TODO: 4. 3. 2022 Implement
    private Player owner;
    public Duck(Player player){
        owner = player;
    }

    public void shoot(){
        System.out.println("You shot duck of player "+ owner.getName() );
        owner.removeLife();
        owner = null;
    }

    @Override
    public String toString() {
        return "Duck of " + owner.getName();
    }
}
