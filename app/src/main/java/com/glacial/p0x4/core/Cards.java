package com.glacial.p0x4.core;

import java.io.Serializable;

/**
 * Created by gcuestab on 10/9/16.
 */
public class Cards implements Serializable {

    public static final int NUM_CARDS = 40;

    public enum State {INCREASE, DECREASE, FINISH};

    private int minCard;
    private int maxCard;

    private int currentCards;
    private int cont;

    private State state;

    public Cards(int numPlayers) {
        this.minCard = 1;
        this.maxCard = NUM_CARDS / numPlayers;

        this.currentCards = 1;
        this.cont = 1;

        this.state = State.INCREASE;
    }

    public int getMinCard() {
        return minCard;
    }

    public void setMinCard(int minCard) {
        this.minCard = minCard;
    }

    public int getMaxCard() {
        return maxCard;
    }

    public void setMaxCard(int maxCard) {
        this.maxCard = maxCard;
    }

    public int getCurrentCards() {
        return currentCards;
    }

    public void setCurrentCards(int currentCards) {
        this.currentCards = currentCards;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void compute(int numPlayers) {
        if (state.equals(State.INCREASE)) {
            if (this.currentCards == this.minCard) {
                if (this.cont == numPlayers) {
                    this.cont = 1;
                    this.currentCards ++;
                }
                else this.cont ++;
            }
            else if (this.currentCards == this.maxCard) {
                if (this.cont == numPlayers) {
                    this.cont = 1;
                    this.currentCards --;
                    this.state = State.DECREASE;
                }
                else this.cont ++;
            }
            else {
                this.currentCards ++;
            }
        }
        else if (state.equals(State.DECREASE)) {
            if (this.currentCards == this.minCard) {
                if (this.cont == numPlayers) {
                    this.state = State.FINISH;
                }
                else this.cont ++;
            }
            else {
                this.currentCards --;
            }
        }
    }
}
