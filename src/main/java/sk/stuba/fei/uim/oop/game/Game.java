package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented.DuckDance;
import sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented.DuckMarch;
import sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented.Roshambo;
import sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented.TurboDuck;
import sk.stuba.fei.uim.oop.game.cards.actioncards.shooting.AimCard;
import sk.stuba.fei.uim.oop.game.cards.actioncards.shooting.ShootCard;
import sk.stuba.fei.uim.oop.game.cards.actioncards.shooting.WildBillCard;
import sk.stuba.fei.uim.oop.game.cards.cardmanagers.Deck;
import sk.stuba.fei.uim.oop.game.player.Player;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Game {
    private Player[] players;
    private final Pond pond;
    private final Deck<ActionCard> actionCards;

    public Game(){
        actionCards = new Deck<>();
        initActionCards();
        initPlayers();
        pond = new Pond().initDeck(players);
        start();
    }

    private void initPlayers(){
        int numberPlayers = ZKlavesnice.readInt("Enter number of players");
        players = new Player[numberPlayers];
        for (int i = 0; i < players.length; i++) {
            String name = ZKlavesnice.readString(String.format("Enter the name of %d. player", i+1));
            Player player = new Player(name);
            player.draw(actionCards);
            player.draw(actionCards);
            player.draw(actionCards);
            players[i] = player;
        }
    }

    public void start(){
        int round = 0;
        while(alivePlayers() != 1){

            Player current = players[round % players.length];
            if(current.isAlive()){
                pond.print();
                current.showCards();
                ActionCard chosenCard = current.performRound(pond);
                current.draw(actionCards);
                actionCards.addToTrash(chosenCard);
                if(!current.isAlive()){
                    current.throwAllCards(actionCards);
                }
            }
            round++;
        }
        printWinner();
    }

    public void printWinner(){
        for(Player p: players){
            if(p.isAlive())
                System.out.println("The winner is: "+p.getName());
        }
    }


    public int alivePlayers(){
        int n = 0;
        for(Player p:players){
            if(p.isAlive())
                n++;
        }
        return n;
    }

    private void initActionCards(){
        for (int i = 0; i < 10; i++) {
            actionCards.addCard(new AimCard());
        }
        for (int i = 0; i < 12; i++) {
            actionCards.addCard(new ShootCard());
        }
        for (int i = 0; i < 2; i++) {
            actionCards.addCard(new WildBillCard());
        }
        for (int i = 0; i < 6; i++) {
            actionCards.addCard(new DuckMarch());
        }
        actionCards.addCard(new TurboDuck());
        actionCards.addCard(new Roshambo());
        actionCards.addCard(new Roshambo());
        actionCards.addCard(new DuckDance());
        actionCards.shuffle();
    }


}
