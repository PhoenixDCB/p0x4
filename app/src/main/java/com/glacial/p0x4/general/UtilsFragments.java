package com.glacial.p0x4.general;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.fragments.AddPlayersFragment;
import com.glacial.p0x4.fragments.PlayersBetFragment;
import com.glacial.p0x4.fragments.PlayersResultsFragment;
import com.glacial.p0x4.fragments.PlayersScoreFragment;

/**
 * Created by dacuesta on 1/9/16.
 */
public class UtilsFragments {
    private enum State {create, score, bet, result}

    private static State state = State.create;

    public static void start(FragmentActivity activity) {
        state = State.create;

        Game game = new Game();

        FragmentManager fManager = activity.getSupportFragmentManager();

        fManager.beginTransaction()
                .replace(R.id.rlContent, AddPlayersFragment.newInstance(game), AddPlayersFragment.TAG)
                .commit();
    }

    public static void goNext(FragmentActivity activity, Game game) {

        UtilsKeyboard.hideKeyboard(activity);

        FragmentManager fManager = activity.getSupportFragmentManager();

        if (state.equals(State.create)) {
            state = State.score;
            fManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_scale_in, R.anim.anim_scale_out)
                    .replace(R.id.rlContent, PlayersScoreFragment.newInstance(game), PlayersScoreFragment.TAG)
                    .commit();
        }
        else if (state.equals(State.score)) {
            state = State.bet;
            fManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_translate_rtl_in, R.anim.anim_translate_rtl_out, R.anim.anim_translate_ltr_in, R.anim.anim_translate_ltr_out)
                    .replace(R.id.rlContent, PlayersBetFragment.newInstance(game), PlayersBetFragment.TAG)
                    .addToBackStack(PlayersScoreFragment.TAG)
                    .commit();
        }
        else if (state.equals(State.bet)) {
            state = State.result;
            fManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_translate_rtl_in, R.anim.anim_translate_rtl_out, R.anim.anim_translate_ltr_in, R.anim.anim_translate_ltr_out)
                    .replace(R.id.rlContent, PlayersResultsFragment.newInstance(game), PlayersResultsFragment.TAG)
                    .addToBackStack(PlayersBetFragment.TAG)
                    .commit();
        }
        else if (state.equals(State.result)) {
            state = State.score;

            fManager.popBackStack();
            fManager.popBackStack();
        }
    }

    public static void goBack()
    {
        if (state.equals(State.bet))
            state = State.score;
        else if (state.equals(State.result))
            state = State.bet;
    }

    public static void start(FragmentActivity activity, Fragment fragment, String tag) {

        FragmentManager fManager = activity.getSupportFragmentManager();

        fManager.beginTransaction()
                .replace(R.id.rlContent, fragment, tag)
                .commit();
    }
}
