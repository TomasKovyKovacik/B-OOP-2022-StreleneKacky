package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public abstract class Card {
    protected String name;
    protected Board board;

    public abstract boolean canPlay();

    public abstract boolean canPlay(int index);

    public void playCard(Player player) {
        System.out.println("--- " + player.getName() + " choose " + this.name + "card to play. ---");
    }

    public void removeCard(Player player) {
        this.board.addActionCard(this);
        player.removeAndTakeNewCard(this.board.getActionCard(),this);
    }

    protected int choosingTile(String type) {
        this.board.printBoard();
        int numberCard = 0;
        while (true){
            numberCard = ZKlavesnice.readInt("*** Enter number of " + type + " tile you want to choose: ***") - 1;
            if (numberCard < 0 || numberCard > 6 || !this.canPlay(numberCard)) {
                System.out.println(" !!! You enter wrong number of tile. Try Again! !!!");
            } else {
                break;
            }
        }
        return numberCard;
    }

    public String getName() {
        return name;
    }
}
