package sk.stuba.fei.uim.oop.game.cards.cardmanagers;

import sk.stuba.fei.uim.oop.game.cards.Card;
import sk.stuba.fei.uim.oop.game.cards.tilecards.TileCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    protected List<Card> deck;
    protected List<Card> trash;
    public Deck(){
        deck = new ArrayList<>();
        trash = new ArrayList<>();

    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card drawCard(){
        if(deck.isEmpty()){
            deck.addAll(trash);
            trash.clear();
            Collections.shuffle(deck);
        }
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
    public void addToTrash(Card card){
        trash.add(card);
    }
    public void addAllCards(List<TileCard> list){ // ?? wtf this??
        deck.addAll(list);
    }
    public void addCard(Card card){
        deck.add(card);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
}
