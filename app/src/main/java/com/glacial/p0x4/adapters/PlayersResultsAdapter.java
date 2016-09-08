package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;
import com.glacial.p0x4.core.Player;

/**
 * Created by dacuesta on 1/9/16.
 */
public class PlayersResultsAdapter extends RecyclerView.Adapter<PlayersResultsAdapter.ViewHolder> {

    private Game game;

    public PlayersResultsAdapter(Game game) {
        this.game = game;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_player_result, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < game.getNumPlayers()) {
            Player player = game.getPlayer(position);
            if (player != null) {
                holder.tvName.setText(player.getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return game.getNumPlayers();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private EditText etResult;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            etResult = (EditText) itemView.findViewById(R.id.etResult);
        }
    }

}
