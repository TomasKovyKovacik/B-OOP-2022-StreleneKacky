package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;

public class DuckDance extends Card {

    public DuckDance(Board board) {
        this.name = "Duck dance!";
        this.board = board;
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public boolean canPlay(int index) {
        return true;
    }

    @Override
    public void playCard(Player player) {
        super.playCard(player);
        this.board.shuffleAllCards();
    }
}
