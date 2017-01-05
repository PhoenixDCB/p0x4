package com.glacial.p0x4.core;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by dacuesta on 3/1/17.
 */

public class ProfilePlayer implements Serializable {

    private String name;
    private int totalMatchesPlayed;
    private int totalMatchesWon;
    private byte[] imageInBytes;

    public ProfilePlayer(@NonNull String name) {
        init(name, 0, 0, null);
    }

    public ProfilePlayer(@NonNull String name, int totalMatchesPlayed, int totalMatchesWon, byte[] imageInBytes) {
        init(name, totalMatchesPlayed, totalMatchesWon, imageInBytes);
    }

    private void init(String name, int totalMatchesPlayed, int totalMatchesWon, byte[] imageInBytes) {
        this.name = name;
        this.totalMatchesPlayed = totalMatchesPlayed;
        this.totalMatchesWon = totalMatchesWon;
        this.imageInBytes = imageInBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMatchesPlayed() {
        return totalMatchesPlayed;
    }

    public void setTotalMatchesPlayed(int totalMatchesPlayed) {
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public int getTotalMatchesWon() {
        return totalMatchesWon;
    }

    public void setTotalMatchesWon(int totalMatchesWon) {
        this.totalMatchesWon = totalMatchesWon;
    }

    public byte[] getImageInBytes() {
        return imageInBytes;
    }

    public void setImageInBytes(byte[] imageInBytes) {
        this.imageInBytes = imageInBytes;
    }

    @Override
    public String toString() {
        return "ProfilePlayer{" +
                "name='" + name + '\'' +
                ", totalMatchesPlayed=" + totalMatchesPlayed +
                ", totalMatchesWon=" + totalMatchesWon +
                ", imageInBytes=" + Arrays.toString(imageInBytes) +
                '}';
    }
}
