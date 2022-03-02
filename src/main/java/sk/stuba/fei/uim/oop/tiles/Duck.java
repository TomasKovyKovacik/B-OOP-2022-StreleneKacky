package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Arrays;

public class Duck extends Tile{
    private final Player player;

    public Duck(Player player) {
        this.player = player;
    }

    @Override
    public String print() {
        return player.getName() + "'s Duck";
    }

    public Player getPlayer() {
        return player;
    }
}
