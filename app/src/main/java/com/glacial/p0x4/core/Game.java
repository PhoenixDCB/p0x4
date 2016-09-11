package com.glacial.p0x4.core;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcuestab on 1/9/16.
 */
public class Game implements Serializable {

    private List<Player> lPlayer, lPlayerBet;
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

    public Player getBetPlayer(int pos) {
        if (pos >= lPlayerBet.size())
            return null;

        return lPlayerBet.get(pos);
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

    public void initPlayerBet() {
        this.lPlayerBet = new ArrayList<>();
        for (Player player : this.lPlayer) {
            lPlayerBet.add(player);
        }
    }

    public void playerBetNextRound() {
        Player firstPlayer = lPlayerBet.remove(0);
        lPlayerBet.add(firstPlayer);
    }

    public void orderPlayerScore() {
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < lPlayer.size() - j; i++) {
                Player currentPlayer = lPlayer.get(i);
                Player nextPlayer = lPlayer.get(i + 1);
                if (currentPlayer.getScore() < nextPlayer.getScore()) {
                    lPlayer.remove(i);
                    lPlayer.add(i, nextPlayer);

                    lPlayer.remove(i + 1);
                    lPlayer.add(i+1, currentPlayer);

                    swapped = true;
                }
            }
        }
    }

    public boolean areBetsCorrect() {
        int bets = 0;
        for (Player p : lPlayer)
            bets += p.getBet();

        return bets != cards.getCurrentCards();
    }

    public boolean isGameFinished() {
        return cards.getState() == Cards.State.FINISH;
    }

    public boolean areResultsCorrect() {
        int results = 0;
        for (Player p : lPlayer)
            results += p.getResult();

        return results == cards.getCurrentCards();
    }

    public boolean isThereAnyAcertant() {
        for (Player p : lPlayer)
            if (p.getResult() == p.getBet())
                return true;

        return false;
    }

    public boolean isThereEnoughPlayers() {
        return lPlayer.size() >= 2;
    }
}
