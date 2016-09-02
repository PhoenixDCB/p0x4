package com.glacial.p0x4.core;

import java.io.Serializable;

/**
 * Created by gcuestab on 1/9/16.
 */
public class Player implements Serializable {

    private String name;
    private int score;

    public Player(String nick, int score) {
        this.name = nick;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
