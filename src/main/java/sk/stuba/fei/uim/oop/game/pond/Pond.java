package sk.stuba.fei.uim.oop.game.pond;

import sk.stuba.fei.uim.oop.game.aimers.Aimer;
import sk.stuba.fei.uim.oop.game.cards.Card;
import sk.stuba.fei.uim.oop.game.cards.cardmanagers.Deck;
import sk.stuba.fei.uim.oop.game.player.Player;
import sk.stuba.fei.uim.oop.game.cards.tilecards.DuckCard;
import sk.stuba.fei.uim.oop.game.cards.tilecards.TileCard;
import sk.stuba.fei.uim.oop.game.cards.tilecards.WaterCard;

import java.util.ArrayList;

public class Pond {

    private final Aimer aimer;
    private final Deck deck;
    private final ArrayList<TileCard> pond;
    private boolean canShoot, canAim;
    public Pond() {
        aimer = new Aimer();
        deck = new Deck();
        pond = new ArrayList<>();
    }

    public Pond initDeck(Player[] players) {
        for (Player p : players) {
            for (int i = 0; i < 5; i++) {
                deck.addCard(new DuckCard(p));
            }
        }
        for (int i = 0; i < 5; i++) {
            deck.addCard(new WaterCard());
        }
        deck.shuffle();
        for (int i = 0; i < 6; i++) {
            pond.add((TileCard) deck.drawCard());
        }
        return this;
    }

    public void march(){
        TileCard toRemove = pond.get(0);
        pond.remove(0);
        deck.addCard(toRemove);
        pond.add((TileCard) deck.drawCard());
    }

    public void dance() {
        deck.addAllCards(pond);
        pond.clear();
        deck.shuffle();
        for (int i = 0; i < 6; i++) {
            pond.add((TileCard) deck.drawCard());
        }
    }

    public boolean moveDuck(int from, int to ){
        if(pond.get(from-1).getDuck() == null){ // if player chose water
            return false;
        }
        TileCard duckCard = pond.get(from-1);
        pond.remove(duckCard);
        pond.add(to-1, duckCard);
        return true;
    }
    public boolean addAimAt(int index) {
        try {
            return aimer.addAimerAt(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index not in range 1 to 6 inclusive!");
            return false;
        }

    }

    public boolean shootAt(int index) {
        try {
            boolean successful = aimer.isAimingAt(index - 1);
            if (successful) {
                TileCard tileCard = pond.get(index-1);
                tileCard.shoot();
                if(tileCard.removeAfterShooting()){
                    removeFromPond(tileCard);
                }
                aimer.removeAimAt(index-1);
            }
            return successful;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index not in range 1 to 6 inclusive!");
            return false;
        }

    }


    private void removeFromPond(TileCard tileCard){
        pond.remove(tileCard);
        pond.add((TileCard) deck.drawCard());
    }

    public ArrayList<TileCard> getPond() {
        return pond;
    }
    public void addToTrash(Card c){
        deck.addToTrash(c);
    }
    public void print(){
        int numberOfAimers = 0;
        for (int i = 0; i < 6; i++) {
            System.out.print((i+1) + ". -> ");
            if(aimer.isAimingAt(i)){
                System.out.print("Aimed - ");
                numberOfAimers++;
            }else{
                System.out.print("Not aimed - ");
            }
            System.out.print(pond.get(i) + "\n");
        }
        if(numberOfAimers == 0){
            canAim = true;
            canShoot = false;
        }else if(numberOfAimers == 6){
            canAim = false;
            canShoot = true;
        }else{
            canAim = true;
            canShoot = true;
        }
    }
    public boolean canAim(){
        return canAim;
    }
    public boolean canShoot(){
        return canShoot;
    }
}
