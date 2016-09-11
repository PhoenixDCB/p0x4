package com.glacial.p0x4.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.glacial.p0x4.R;
import com.glacial.p0x4.activities.MainActivity;
import com.glacial.p0x4.adapters.PlayersResultsAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;
import com.glacial.p0x4.general.UtilsFragments;

/**
 * Created by gcuestab on 2/9/16.
 */
public class PlayersResultsFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = PlayersResultsFragment.class.getName();

    public static PlayersResultsFragment newInstance(Game game) {
        PlayersResultsFragment f = new PlayersResultsFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    private Game game;

    public PlayersResultsFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players_results, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity)this.getActivity()).getTvTBarTitle().setText(getString(R.string.results_title_fragment));

        game = (Game) getArguments().getSerializable(Constants.GAME);

        PlayersResultsAdapter playersResultsAdapter = new PlayersResultsAdapter(game);

        RecyclerView rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(playersResultsAdapter);

        Button bNext = (Button) view.findViewById(R.id.bNext);
        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                if (game.areResultsCorrect()) {
                    if (game.isThereAnyAcertant()) {
                        game.computePlayerScores();
                        game.computeCards();
                        game.playerBetNextRound();
                        game.orderPlayerScore();
                    }
                    UtilsFragments.goNext(getActivity().getSupportFragmentManager(), game);
                }
                break;
        }
    }
}
