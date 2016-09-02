package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
    private String lastText = "";

    public AddPlayersAdapter(Game game) {
        this.game = game;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_new_player, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < game.getNumPlayers()) {
            holder.etPlayer.setEnabled(false);
            holder.etPlayer.setText(game.getPlayer(position).getName());
            holder.bAdd.setVisibility(View.GONE);
        } else {

            holder.etPlayer.setEnabled(true);
            holder.etPlayer.setText(lastText);
            holder.bAdd.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return game.getNumPlayers() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private EditText etPlayer;
        private Button bAdd;

        public ViewHolder(View itemView) {
            super(itemView);

            etPlayer = (EditText) itemView.findViewById(R.id.etPlayer);
            etPlayer.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (ViewHolder.this.getAdapterPosition() == game.getNumPlayers())
                        lastText = s.toString();
                }
            });

            bAdd = (Button) itemView.findViewById(R.id.bAdd);
            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (game.addPlayer(etPlayer.getText().toString())) {
                        lastText = "";
                        AddPlayersAdapter.this.notifyDataSetChanged();
                    }
                }
            });


        }
    }

}
