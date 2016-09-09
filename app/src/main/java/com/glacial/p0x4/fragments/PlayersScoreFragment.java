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
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.adapters.PlayersScoreAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;
import com.glacial.p0x4.general.UtilsFragments;

/**
 * Created by gcuestab on 2/9/16.
 */
public class PlayersScoreFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = PlayersScoreFragment.class.getName();

    public static PlayersScoreFragment newInstance(Game game) {
        PlayersScoreFragment f = new PlayersScoreFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    private Game game;

    public PlayersScoreFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players_score, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        game = (Game) getArguments().getSerializable(Constants.GAME);

        TextView tvCardsDeliver = (TextView) view.findViewById(R.id.tvCardsDeliver);
        tvCardsDeliver.setText(String.valueOf(game.getCurrentCards()));

        PlayersScoreAdapter playersScoreAdapter = new PlayersScoreAdapter(game);

        RecyclerView rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(playersScoreAdapter);

        Button bNext = (Button) view.findViewById(R.id.bNext);
        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                UtilsFragments.goNext(getActivity().getSupportFragmentManager(), game);
                break;
        }
    }
}
