package sk.stuba.fei.uim.oop.game.cards.cardmanagers;

import sk.stuba.fei.uim.oop.game.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetterDeck<T extends Card>{
    private List<T> deck;
    private List<T> trash;

    public BetterDeck(){
        deck = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public List<T> getDeck(){
        return deck;
    }

    public T drawCard(){
        if(deck.isEmpty()){
            deck.addAll(trash);
            trash.clear();
            shuffle();
        }
        T card = deck.get(0);
        deck.remove(card);
        return card;
    }

    public void addToTrash(T card){
        trash.add(card);
    }

    public void addCard(T card){
        deck.add(card);
    }

    public void addAllCards(List<T> cards){
        deck.addAll(cards);

    }

    private void shuffle(){
        Collections.shuffle(deck);
    }
}
