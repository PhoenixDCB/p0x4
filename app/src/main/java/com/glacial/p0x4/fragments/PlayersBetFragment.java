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
import com.glacial.p0x4.adapters.PlayersBetAdapter;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.general.Constants;
import com.glacial.p0x4.general.DialogManager;
import com.glacial.p0x4.general.UtilsFragments;
import com.glacial.p0x4.general.UtilsRecyclerView;

/**
 * Created by gcuestab on 4/9/16.
 */
public class PlayersBetFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = PlayersBetFragment.class.getName();

    public static PlayersBetFragment newInstance(Game game) {
        PlayersBetFragment f = new PlayersBetFragment();

        Bundle b = new Bundle();
        b.putSerializable(Constants.GAME, game);
        f.setArguments(b);

        return f;
    }

    private RecyclerView rvPlayers;
    private Button bNext;
    private PlayersBetAdapter playersBetAdapter;
    private Game game;

    public PlayersBetFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players_bet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity)this.getActivity()).getTvTBarTitle().setText(getString(R.string.bets_title_fragment));

        game = (Game) getArguments().getSerializable(Constants.GAME);

        playersBetAdapter = new PlayersBetAdapter(game);

        rvPlayers = (RecyclerView) view.findViewById(R.id.rvPlayers);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPlayers.setAdapter(playersBetAdapter);

        bNext = (Button) view.findViewById(R.id.bNext);
        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:

                if (areAllBetsFilled())
                    if (game.areBetsCorrect())
                        UtilsFragments.goNext(getActivity(), game);
                    else
                        DialogManager.showDialog(
                                getActivity(),
                                getString(R.string.dialog_title_warning),
                                getString(R.string.dialog_body_bets_not_equals),
                                getString(R.string.dialog_button_accept),
                                null);
                break;
        }
    }

    private boolean areAllBetsFilled() {
        boolean allTextsFilled = true;

        for (int i = 0; i < UtilsRecyclerView.getItemCount(rvPlayers); i++) {

            PlayersBetAdapter.ViewHolder vh = (PlayersBetAdapter.ViewHolder) UtilsRecyclerView.getViewHolder(rvPlayers, i);

            if (vh.etBet.getText().toString().isEmpty()) {
                allTextsFilled = false;
                vh.etBet.setError(getString(R.string.bets_edittext_empty));
                vh.etBet.setBackgroundResource(R.drawable.p0x4_edit_text_error);
            }
        }

        return allTextsFilled;
    }
}
