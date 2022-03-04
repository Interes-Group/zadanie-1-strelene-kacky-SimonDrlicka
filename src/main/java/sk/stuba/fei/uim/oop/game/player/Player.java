package sk.stuba.fei.uim.oop.game.player;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.cards.cardmanagers.Deck;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int remainingLives;
    private List<ActionCard> actionCards;
    private Game game;
    public Player( String name){
        this.name = name;
        actionCards = new ArrayList<>();
        remainingLives = 5;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return remainingLives > 0;
    }
    public void removeLife(){
        remainingLives--;
    }
    public void draw(Deck deck){
        actionCards.add((ActionCard) deck.drawCard());
    }

    public void showCards() {
        System.out.println("Cards of "+name );
        for(ActionCard card: actionCards){
            System.out.println(card);
        }
    }

    public void performRound(Pond pond) {
        int choice = ZKlavesnice.readInt("Choose card you want to play (1-3)");
        ActionCard chosen = actionCards.get(choice-1);
        chosen.performAction(pond);
        actionCards.remove(chosen);
    }
}
