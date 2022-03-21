package sk.stuba.fei.uim.oop.ducks;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Ducks {
    private final Player[] players;
    private int currentPlayer;
    private Board board;

    public Ducks() {
        System.out.println("--- Welcome to FEI SHOT DUCKS ---");
        int numberPlayers = 0;
        while (numberPlayers < 2 || numberPlayers > 6) {
            numberPlayers = ZKlavesnice.readInt("*** Enter number of players (2-6): ***");
            if (numberPlayers < 2 || numberPlayers > 6) {
                System.out.println(" !!! You enter wrong number of players. Try Again! !!!");
            }
        }
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("*** Enter name for PLAYER " + (i+1) + " : ***"));
        }

        this.board = new Board(this.players);
        this.startGame();
    }

    private void startGame() {
        System.out.println("--- GAME STARTED ---");
        while (this.getNumberOfActivePlayers() > 1) {
            Player activePlayer = this.players[this.currentPlayer];
            if (!activePlayer.isActive()) {
                ArrayList<Card> cardsToDeck = activePlayer.removeCardsFromHand();
                for (Card card : cardsToDeck) {
                    this.board.addActionCard(card);
                }
                this.incrementCounter();
                continue;
            }

            System.out.println("--- PLAYER " + activePlayer.getName() + " STARTS TURN ---");
            System.out.println("--- " + activePlayer.getName() + "'s lives: " + activePlayer.getLives() + " ---");
            this.makeTurn(activePlayer);
            this.incrementCounter();
        }
        System.out.println("--- GAME FINISHED ---");
        System.out.println("*** And the WINNER is " + getWinner().getName() + " ***");
    }

    private void makeTurn(Player activePlayer) {
        this.board.printBoard();
        ArrayList<Card> playableCards = activePlayer.getPlayableCards();
        if (playableCards.size() != 0) {
            this.playCard(playableCards, activePlayer);
        } else {
            this.removeCard(activePlayer);
        }
    }

    private void removeCard(Player activePlayer) {
        System.out.println("--- There are no playable cards on your hand! Which card do you want to throw away? ---");
        ArrayList<Card> cards = activePlayer.getAllCards();
        int numberCard = choosingCard(cards, "REMOVE");
        cards.get(numberCard).removeCard(activePlayer);
    }

    private void playCard(ArrayList<Card> playableCards, Player activePlayer) {
        System.out.println("--- Playable cards on hand ---");
        int numberCard = choosingCard(playableCards, "PLAY");
        playableCards.get(numberCard).playCard(activePlayer);
        this.board.addActionCard(playableCards.get(numberCard));
        activePlayer.removeAndTakeNewCard(playableCards.get(numberCard), this.board.getActionCard());
    }

    private int choosingCard(ArrayList<Card> cards, String verb) {
        for (int i = 0; i < cards.size();i++) {
            System.out.println("Card " + (i+1) + ":" + cards.get(i).getName());
        }
        int numberCard = 0;
        while (true) {
            numberCard = ZKlavesnice.readInt("*** Enter number of card you want to " + verb + ": ***") - 1;
            if (numberCard < 0 || numberCard > cards.size() - 1) {
                System.out.println(" !!! You enter wrong number of card. Try Again! !!! ");
            } else {
                break;
            }
        }
        return numberCard;
    }

    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
    }

    private int getNumberOfActivePlayers() {
        int count = 0;
        for (Player player : this.players) {
            if (player.isActive()) {
                count++;
            }
        }
        return count;
    }

    private Player getWinner() {
        for (Player player : this.players) {
            if (player.isActive()) {
                return player;
            }
        }
        return null;
    }
}
