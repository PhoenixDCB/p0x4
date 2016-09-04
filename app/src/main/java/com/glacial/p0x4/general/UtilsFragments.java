package com.glacial.p0x4.general;

import android.support.v4.app.FragmentManager;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.fragments.AddPlayersFragment;
import com.glacial.p0x4.fragments.PlayersBetFragment;
import com.glacial.p0x4.fragments.PlayersScoreFragment;

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

    public static void goNext(FragmentManager fManager, Game game) {
        if (state.equals(State.create)) {
            state = State.score;
            fManager.beginTransaction()
                    .replace(R.id.rlContent, PlayersScoreFragment.newInstance(game), PlayersScoreFragment.TAG)
                    .commit();
        }
        else if (state.equals(State.score)) {
            state = State.bet;
            fManager.beginTransaction()
                    .replace(R.id.rlContent, PlayersBetFragment.newInstance(game), PlayersBetFragment.TAG)
                    .addToBackStack(PlayersBetFragment.TAG)
                    .commit();
        }
        else if (state.equals(State.bet)) {
            state = State.result;
        }
        else if (state.equals(State.result)) {
            state = State.score;
        }
    }
}
