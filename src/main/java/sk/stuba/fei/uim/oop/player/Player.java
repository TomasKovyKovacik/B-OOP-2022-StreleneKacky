package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Player {

    private final String name;
    private int lives;
    private Card[] cards;

    public Player(String name) {
        this.cards = new Card[3];
        this.name = name;
        this.lives = 5;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
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
        return new ArrayList<>(Arrays.asList(this.cards));
    }

    public boolean isActive() {
        return this.lives > 0;
    }

    public void removeLife() {
        this.lives--;
    }

    public void removeAndTakeNewCard(Card oldCard, Card newCard) {
        for (int i = 0; i < this.cards.length; i++) {
            if (Objects.equals(this.cards[i], oldCard)) {
                this.cards[i] = newCard;
            }
        }
    }

}
