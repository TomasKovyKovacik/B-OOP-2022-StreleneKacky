package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Duck;
import sk.stuba.fei.uim.oop.tiles.Tile;
import sk.stuba.fei.uim.oop.tiles.Water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    private boolean[] aimTiles;
    private Tile[] pond;
    private ArrayList<Tile> deck;
    private ArrayList<Card> actionCards;

    public Board(Player[] players) {
        ArrayList<Tile> cards = new ArrayList<Tile>();
        for (int i = 0; i < 5; i++) {
            cards.add(new Water());
        }
        for (Player player: players) {
            for (int i = 0; i < 5; i++) {
                cards.add(new Duck(player));
            }
        }
        Collections.shuffle(cards);

        this.pond = new Tile[6];
        for (int i = 0; i < 6; i++) {
            this.pond[i] = cards.remove(cards.size() - 1);
        }
        this.deck = new ArrayList<Tile>();
        this.deck.addAll(cards);
        this.aimTiles = new boolean[6];
        for (int i = 0; i < 6; i++) {
            this.aimTiles[i] = false;
        }

        this.actionCards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            actionCards.add(new Shooting(this));
        }
        for (int i = 0; i < 10; i++) {
            actionCards.add(new Aim(this));
        }
        for (int i = 0; i < 6; i++) {
            actionCards.add(new DuckMarch(this));
        }
        actionCards.add(new CrazyBill(this));
        actionCards.add(new CrazyBill(this));
        actionCards.add(new DuckDance(this));
        actionCards.add(new TurboDuck(this));
        actionCards.add(new WaterWhirlpool(this));
        actionCards.add(new WaterWhirlpool(this));


        Collections.shuffle(this.actionCards);
        for (Player player : players) {
            Card[] newCards = new Card[3];
            for (int i = 0; i < 3; i++) {
                newCards[i] = actionCards.remove(0);
            }
            player.setCards(newCards);
        }
    }

    public void printBoard() {
        System.out.println("---- POND ----");
        System.out.println("----- finish -----");
        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + ". *  " + (this.aimTiles[i] ? "Aimed!" : "Empty!" ) + "  *  " + this.pond[i].print());
        }
        System.out.println("----- start -----");
    }

    public boolean canAim() {
        for (boolean aim : this.aimTiles) {
            if (!aim) {
                return true;
            }
        }
        return false;
    }

    public boolean isAimed() {
        for (boolean aim : this.aimTiles) {
            if (aim) {
                return true;
            }
        }
        return false;
    }

    public boolean[] getAimTiles() {
        return this.aimTiles;
    }

    public Tile[] getPond() {
        return this.pond;
    }

    public void movePond(int index, boolean backToDeck) {
        if (backToDeck) {
            this.deck.add(this.pond[0]);
        }
        for (int i = index; i < this.pond.length - 1; i++) {
            this.pond[i] = this.pond[i + 1];
        }
        this.pond[this.pond.length - 1] = this.deck.remove(0);
    }

    public void moveDuck(int index) {
        Tile temp = this.pond[index];
        for (int i = index; i > 0; i--) {
            this.pond[i] = this.pond[i - 1];
        }
        this.pond[0] = temp;
    }

    public void shufflePond() {
        List<Tile> pondList = Arrays.asList(this.pond);
        Collections.shuffle(pondList);
        pondList.toArray(this.pond);
    }

    public void shuffleAllCards() {
        List<Tile> list = new ArrayList<>(this.deck);
        list.addAll(Arrays.asList(this.pond));
        Collections.shuffle(list);

        for (int i = 0; i < 6; i++) {
            this.pond[i] = list.remove(list.size() - 1);
        }
        this.deck = new ArrayList<>(list);
    }

    public void setAimTile(int index, boolean value) {
        this.aimTiles[index] = value;
    }

    public Card getActionCard() {
        return this.actionCards.remove(0);
    }

    public void addActionCard(Card card) {
        this.actionCards.add(card);
    }
}
