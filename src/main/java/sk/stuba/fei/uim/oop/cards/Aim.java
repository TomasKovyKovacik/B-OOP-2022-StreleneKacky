package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;

public class Aim extends Card {
    private static final String CARD_NAME = "Aim!";

    public Aim(Board board) {
        super(CARD_NAME, board);
    }

    @Override
    public boolean canPlay() {
        return this.board.canAim();
    }

    @Override
    public boolean canPlay(int index) {
        return !this.board.getAimTiles()[index];
    }

    @Override
    public void playCard(Player player) {
        super.playCard(player);
        int tile = this.choosingTile("AIM");
        this.board.setAimTile(tile, true);
    }
}
