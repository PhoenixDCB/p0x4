package com.glacial.p0x4.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glacial.p0x4.R;
import com.glacial.p0x4.adapters.AddPlayersAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;

/**
 * Created by dacuesta on 1/9/16.
 */
public class AddPlayersFragment extends Fragment {

    public static String TAG = "AddPlayersFragment";
    public static AddPlayersFragment newInstance(Game game) {
        AddPlayersFragment f = new AddPlayersFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    private RecyclerView rvPlayers;
    private AddPlayersAdapter addPlayersAdapter;

    public AddPlayersFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_players, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        addPlayersAdapter = new AddPlayersAdapter();

        rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(addPlayersAdapter);
    }
}
