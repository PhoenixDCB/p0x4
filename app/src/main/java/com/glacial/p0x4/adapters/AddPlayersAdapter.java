package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;

/**
 * Created by dacuesta on 1/9/16.
 */
public class AddPlayersAdapter extends RecyclerView.Adapter<AddPlayersAdapter.ViewHolder> {

    private Game game;

    public AddPlayersAdapter(Game game) {
        this.game = game;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_new_player, parent, false);
        return new ViewHolder(v, game);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
//        return game.getlPlayer().size() + 1;
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private EditText etPlayer;
        private Button bAdd;

        public ViewHolder(View itemView, final Game game) {
            super(itemView);

            etPlayer = (EditText) itemView.findViewById(R.id.etPlayer);
            bAdd = (Button) itemView.findViewById(R.id.bAdd);

            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    game.addPlayer(etPlayer.getText().toString());
                    AddPlayersAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

}
