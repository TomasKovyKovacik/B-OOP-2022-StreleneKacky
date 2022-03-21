package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private final String name;
    private int lives;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.cards = new ArrayList<Card>();
        this.name = name;
        this.lives = 5;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> removeCardsFromHand() {
        ArrayList<Card> removedCards = new ArrayList<>(this.cards);
        this.cards.clear();
        return removedCards;
    }

    public ArrayList<Card> getPlayableCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (Card card : this.cards) {
            if (card.canPlay()) {
                cards.add(card);
            }
        }
        return cards;
    }

    public ArrayList<Card> getAllCards() {
        return this.cards;
    }

    public boolean isActive() {
        return this.lives > 0;
    }

    public void removeLife() {
        this.lives--;
    }

    public void removeAndTakeNewCard(Card oldCard, Card newCard) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (Objects.equals(this.cards.get(i), oldCard)) {
                this.cards.remove(i);
                this.cards.add(i, newCard);
                break;
            }
        }
    }

}
