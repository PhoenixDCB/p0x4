package com.glacial.p0x4.fragments;

import android.content.Intent;
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
import com.glacial.p0x4.adapters.ProfilePlayersAdapter;
import com.glacial.p0x4.application.GlacialApplication;
import com.glacial.p0x4.core.Profile;

/**
 * Created by dacuesta on 1/9/16.
 */
public class ProfilePlayersFragment extends Fragment implements View.OnClickListener {

    public final static String TAG = ProfilePlayersFragment.class.getName();

    public static ProfilePlayersFragment newInstance() {
        ProfilePlayersFragment f = new ProfilePlayersFragment();

        Bundle b = new Bundle();
        f.setArguments(b);

        return f;
    }

    private RecyclerView rvPlayers;
    private ProfilePlayersAdapter playersAdapter;
    private Button bAddPlayer;
    private Button bStartGame;

    private Profile profile;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_players, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // Init variables
        GlacialApplication app = (GlacialApplication) getActivity().getApplication();
        profile = app.getProfile();

        // Init adapters
        playersAdapter = new ProfilePlayersAdapter(this, profile);

        initViews();
        initValues();
        initListeners();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bAddPlayer:
                profile.addNewPlayer("Player " + profile.getPlayers().size());
                playersAdapter.notifyDataSetChanged();
                break;

            case R.id.bStartGame:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void initViews() {
        rvPlayers = (RecyclerView) getView().findViewById(R.id.rvPlayers);
        bAddPlayer = (Button) getView().findViewById(R.id.bAddPlayer);
        bStartGame = (Button) getView().findViewById(R.id.bStartGame);
    }

    private void initValues() {
        rvPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPlayers.setAdapter(playersAdapter);
    }

    private void initListeners() {
        bAddPlayer.setOnClickListener(this);
        bStartGame.setOnClickListener(this);
    }
}
