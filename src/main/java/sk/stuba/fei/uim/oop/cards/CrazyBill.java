package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;

public class CrazyBill extends Shooting {

    public CrazyBill(Board board) {
        super(board);
        this.name = "CrazyBill";
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
}
