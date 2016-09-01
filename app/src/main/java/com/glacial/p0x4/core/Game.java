package com.glacial.p0x4.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcuestab on 1/9/16.
 */
public class Game {

    private List<Player> lPlayer;

    public Game() {
        lPlayer = new ArrayList<>();
    }

    public void addPlayer(String name){
        Player p = new Player(name, 0);
        lPlayer.add(p);
    }
}
