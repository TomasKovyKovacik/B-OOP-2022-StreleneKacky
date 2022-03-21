package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;

public class CrazyBill extends Shooting {
    private static final String CARD_NAME = "CrazyBill";

    public CrazyBill(Board board) {
        super(board);
        this.name = CARD_NAME;
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public boolean canPlay(int index) {
        return true;
    }
}
