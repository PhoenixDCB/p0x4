package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;

/**
 * Created by gcuestab on 4/9/16.
 */
public class PlayersBetAdapter extends RecyclerView.Adapter<PlayersBetAdapter.ViewHolder> {

    private Game game;

    public PlayersBetAdapter(Game game) {
        this.game = game;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_player_bet, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
