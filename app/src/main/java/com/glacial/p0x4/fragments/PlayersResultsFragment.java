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
import com.glacial.p0x4.general.DialogManager;
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

    private RecyclerView rvPlayers;
    private Button bNext;
    private PlayersResultsAdapter playersResultsAdapter;
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

        playersResultsAdapter = new PlayersResultsAdapter(game);

        rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(playersResultsAdapter);

        bNext = (Button) view.findViewById(R.id.bNext);
        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                if (areAllResultsFilled())
                    if (game.areResultsCorrect()) {
                        if (game.isThereAnyAcertant()) {
                            game.computePlayerScores();
                            game.computeCards();
                            game.playerBetNextRound();
                            game.orderPlayerScore();
                        } else
                            DialogManager.showDialog(
                                    getActivity(),
                                    getString(R.string.dialog_title_warning),
                                    getString(R.string.dialog_body_none_has_won),
                                    getString(R.string.dialog_button_accept),
                                    null);
                        UtilsFragments.goNext(getActivity().getSupportFragmentManager(), game);
                    } else
                        DialogManager.showDialog(
                                getActivity(),
                                getString(R.string.dialog_title_warning),
                                getString(R.string.dialog_body_results_equals),
                                getString(R.string.dialog_button_accept),
                                null);
                break;
        }
    }

    private boolean areAllResultsFilled() {
        boolean allTextsFilled = true;

        for (int i = 0; i < rvPlayers.getLayoutManager().getItemCount(); i++) {

            View v = rvPlayers.getLayoutManager().findViewByPosition(i);
            PlayersResultsAdapter.ViewHolder vh = (PlayersResultsAdapter.ViewHolder) rvPlayers.getChildViewHolder(v);

            if (vh.etResult.getText().toString().isEmpty()) {
                allTextsFilled = false;
                vh.etResult.setError(getString(R.string.results_edittext_empty));
            }
        }

        return allTextsFilled;
    }
}
