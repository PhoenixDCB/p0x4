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
import com.glacial.p0x4.adapters.AddPlayersAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;
import com.glacial.p0x4.general.UtilsFragments;

/**
 * Created by dacuesta on 1/9/16.
 */
public class AddPlayersFragment extends Fragment implements View.OnClickListener {

    public final static String TAG = AddPlayersFragment.class.getName();
    public static AddPlayersFragment newInstance(Game game) {
        AddPlayersFragment f = new AddPlayersFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    private RecyclerView rvPlayers;
    private AddPlayersAdapter addPlayersAdapter;

    private Game game;

    public AddPlayersFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_players, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        game = (Game) bundle.getSerializable(Constants.GAME);

        addPlayersAdapter = new AddPlayersAdapter(game);

        rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(addPlayersAdapter);

        Button bNext = (Button) view.findViewById(R.id.bNext);
        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                game.initCards();
                game.initPlayerBet();
                UtilsFragments.goNext(getActivity().getSupportFragmentManager(), game);
                break;
        }
    }
}
