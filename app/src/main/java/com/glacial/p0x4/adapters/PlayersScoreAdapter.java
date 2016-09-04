package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.core.Player;

import org.w3c.dom.Text;

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
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < game.getNumPlayers()) {
            Player player = game.getPlayer(position);
            if (player != null) {
                holder.tvName.setText(player.getName());
                holder.tvScore.setText(Integer.toString(player.getScore()));
            }
        }
    }

    @Override
    public int getItemCount() {
        return game.getNumPlayers();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvScore;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvScore = (TextView) itemView.findViewById(R.id.tvScore);
        }
    }

}
