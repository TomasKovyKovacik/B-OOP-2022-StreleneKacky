package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Duck;

public class Shooting extends Card {

    public Shooting(Board board) {
        this.name = "Shooting!";
        this.board = board;
    }

    @Override
    public boolean canPlay() {
        return this.board.isAimed();
    }

    @Override
    public boolean canPlay(int index) {
        return this.board.getAimTiles()[index];
    }

    @Override
    public void playCard(Player player) {
        super.playCard(player);
        int tile = this.choosingTile("POND");
        if (this.board.getPond()[tile] instanceof Duck) {
            ((Duck) this.board.getPond()[tile]).getPlayer().removeLife();
            this.board.movePond(tile, false);
        }
        this.board.setAimTile(tile, false);
    }
}
