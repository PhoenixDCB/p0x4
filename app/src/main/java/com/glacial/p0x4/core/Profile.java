package com.glacial.p0x4.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dacuesta on 3/1/17.
 */

public class Profile implements Serializable {

    private List<ProfilePlayer> players;

    public Profile() {
        players = new ArrayList<>();
    }

    public List<ProfilePlayer> getPlayers() {
        return players;
    }

    public void addNewPlayer(String name) {
        ProfilePlayer player = new ProfilePlayer(name);
        players.add(player);
    }
}
