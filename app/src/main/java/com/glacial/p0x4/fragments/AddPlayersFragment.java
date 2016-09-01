package com.glacial.p0x4.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glacial.p0x4.R;

/**
 * Created by dacuesta on 1/9/16.
 */
public class AddPlayersFragment extends Fragment {

    public static String TAG = "AddPlayersFragment";
    public static AddPlayersFragment newInstance() {
        return new AddPlayersFragment();
    }

    public AddPlayersFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_players, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }
}
