package com.glacial.p0x4.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
            final Player player = game.getBetPlayer(position);
            if (player != null) {
                holder.tvName.setText(player.getName());
            }

            // set background
            if (position == 0) holder.itemView.setBackgroundResource(R.drawable.p0x4_item_make_bet);
            else if (position == game.getNumPlayers()-1) holder.itemView.setBackgroundResource(R.drawable.p0x4_item_deliver);
        }
    }

    @Override
    public int getItemCount() {
        return game.getNumPlayers();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public EditText etResult;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);

            etResult = (EditText) itemView.findViewById(R.id.etResult);
            etResult.addTextChangedListener(twResult);
            etResult.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) etResult.setBackgroundResource(R.drawable.p0x4_edit_text_selected);
                    else etResult.setBackgroundResource(R.drawable.p0x4_edit_text_default);
                }
            });
        }

        private TextWatcher twResult = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {

                    //get the result
                    int result = Integer.parseInt(s.toString());

                    //check if we get a result greater than the cards we have
                    if (result > game.getCurrentCards()) {

                        //the result is equals to the cards we have
                        result = game.getCurrentCards();

                        //change the edit text
                        etResult.removeTextChangedListener(twResult);
                        etResult.setText(String.valueOf(result));
                        etResult.setSelection(etResult.getText().length());
                        etResult.addTextChangedListener(twResult);

                    }

                    //update the result of the player
                    Player player = game.getBetPlayer(getAdapterPosition());
                    player.setResult(result);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

}
