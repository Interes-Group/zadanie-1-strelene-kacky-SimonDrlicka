package sk.stuba.fei.uim.oop.game.cards.tilecards;

public class WaterCard extends TileCard{
    public WaterCard(){
        super(null);
    }

    @Override
    public TileCard shoot() {
        System.out.println("Missed! You shot into water!");
        return this;
    }

    @Override
    public boolean removeAfterShooting() {
        return false;
    }

    @Override
    public String toString() {
        return "Water card";
    }
}
