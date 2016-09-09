package com.glacial.p0x4.core;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcuestab on 1/9/16.
 */
public class Game implements Serializable {

    private List<Player> lPlayer;
    private Cards cards;

    public Game() {
        lPlayer = new ArrayList<>();
    }

    public boolean addPlayer(String name){
        if (TextUtils.isEmpty(name))
            return false;

        for (Player p: lPlayer) {
            if (p.getName().equals(name)) return false;
        }

        Player p = new Player(name, 0);
        lPlayer.add(p);
        return true;
    }

    public void removePlayer(int position) {
        lPlayer.remove(position);
    }

    public int getNumPlayers() {
        return lPlayer.size();
    }

    public Player getPlayer(int pos) {
        if (pos >= lPlayer.size())
            return null;

        return lPlayer.get(pos);
    }

    public void setPlayerBet(int position, int bet) {
        this.lPlayer.get(position).setBet(bet);
    }

    public void setPlayerResult(int position, int result) {
        this.lPlayer.get(position).setResult(result);
    }

    public void computePlayerScores() {
        for (Player player: lPlayer) {
            player.computeScore();
        }
    }

    public void initCards() {
        this.cards = new Cards(this.lPlayer.size());
    }

    public void computeCards() {
        this.cards.compute(this.lPlayer.size());
    }

    public int getCurrentCards() {
        return this.cards.getCurrentCards();
    }
}
