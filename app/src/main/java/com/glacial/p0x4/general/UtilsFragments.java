package com.glacial.p0x4.general;

import android.support.v4.app.FragmentManager;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.fragments.AddPlayersFragment;

/**
 * Created by dacuesta on 1/9/16.
 */
public class UtilsFragments {
    private enum State {create, score, bet, result}

    private static State state = State.create;

    public static void start(FragmentManager fManager) {
        state = State.create;

        Game game = new Game();

        fManager.beginTransaction()
                .replace(R.id.rlContent, AddPlayersFragment.newInstance(game), AddPlayersFragment.TAG)
                .commit();
    }

    public static void goNext(FragmentManager fManager) {
        //TODO: make the method. This is a dummy version. You r right man!
        state = State.score;
        fManager.beginTransaction()
                .replace(R.id.rlContent, AddPlayersFragment.newInstance(null), AddPlayersFragment.TAG)
                .commit();
    }
}
