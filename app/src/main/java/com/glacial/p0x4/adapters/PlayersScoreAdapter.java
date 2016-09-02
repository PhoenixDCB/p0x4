package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;

/**
 * Created by dacuesta on 1/9/16.
 */
public class PlayersScoreAdapter extends RecyclerView.Adapter<PlayersScoreAdapter.ViewHolder> {

    private Game game;

    public PlayersScoreAdapter(Game game) {
        this.game = game;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_player_score, parent, false);
        return new ViewHolder(v, game);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
//        return game.getlPlayer().size();
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView, Game game) {
            super(itemView);
        }
    }

}
