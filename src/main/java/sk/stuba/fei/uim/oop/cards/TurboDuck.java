package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Duck;

public class TurboDuck extends Card {
    private static final String CARD_NAME = "Turbo Duck";

    public TurboDuck(Board board) {
        super(CARD_NAME, board);
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public boolean canPlay(int index) {
        return this.board.getPond()[index] instanceof Duck;
    }

    @Override
    public void playCard(Player player) {
        super.playCard(player);
        int tile = this.choosingTile("POND");
        this.board.moveDuck(tile);
    }
}
