package com.glacial.p0x4.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glacial.p0x4.R;
import com.glacial.p0x4.adapters.PlayersBetAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;

/**
 * Created by gcuestab on 4/9/16.
 */
public class PlayersBetFragment extends Fragment {
    public static final String TAG = PlayersBetFragment.class.getName();

    public static PlayersBetFragment newInstance(Game game) {
        PlayersBetFragment f = new PlayersBetFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    public PlayersBetFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players_bet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final Game game = (Game) getArguments().getSerializable(Constants.GAME);

        PlayersBetAdapter playersBetAdapter = new PlayersBetAdapter(game);

        RecyclerView rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(playersBetAdapter);
    }
}
