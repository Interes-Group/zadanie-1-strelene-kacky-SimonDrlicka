package sk.stuba.fei.uim.oop.game.player;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.cards.actioncards.shooting.AimCard;
import sk.stuba.fei.uim.oop.game.cards.actioncards.shooting.ShootCard;
import sk.stuba.fei.uim.oop.game.cards.cardmanagers.Deck;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int remainingLives;
    private final List<ActionCard> actionCards;
    public Player(String name){
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
        if(remainingLives == 0) System.out.println(name + ", died!");

    }
    public void draw(Deck<ActionCard> deck){
        actionCards.add(deck.drawCard());
    }

    public void showCards() {
        System.out.println("\n******Cards of "+name + "******");
        System.out.println("You have " + remainingLives + " ducks left.");
        for(ActionCard card: actionCards){
            System.out.println(card);
        }
    }

    public ActionCard performRound(Pond pond) {

        if(actionCards.get(0) instanceof ShootCard
                && actionCards.get(1) instanceof ShootCard
                && actionCards.get(2) instanceof ShootCard
                && !pond.canShoot()){
            System.out.println("You cant use any shoot card. You are throwing one away");
            ActionCard chosen = actionCards.get(0);
            actionCards.remove(0);
            return chosen;
        }else if(actionCards.get(0) instanceof AimCard
                && actionCards.get(1) instanceof AimCard
                && actionCards.get(2) instanceof AimCard
                && !pond.canAim()){
            System.out.println("You cant use any Aim card. You are throwing one away");
            ActionCard chosen = actionCards.get(0);
            actionCards.remove(0);
            return chosen;
        }else{
            int choice = ZKlavesnice.readInt("Choose card you want to play (1-3): ");
            while( 1>choice || choice > 3){
                choice = ZKlavesnice.readInt("Choose card you want to play (1-3): ");
            }

            ActionCard chosen = actionCards.get(choice-1);
            chosen.performAction(pond);
            actionCards.remove(chosen);

            return chosen;
        }
    }

    public void throwAllCards(Deck<ActionCard> d){
        for(ActionCard actionCard: actionCards){
            d.addToTrash(actionCard);
        }
        actionCards.clear();
    }
}
