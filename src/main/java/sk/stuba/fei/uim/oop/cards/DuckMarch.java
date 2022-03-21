package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;

public class DuckMarch extends Card {
    private static final String CARD_NAME = "Duck March";

    public DuckMarch(Board board) {
        super(CARD_NAME, board);
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
        this.board.movePond(0, true);
    }
}
