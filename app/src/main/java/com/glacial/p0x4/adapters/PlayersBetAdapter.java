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
        if (position < game.getNumPlayers()) {
            Player player = game.getBetPlayer(position);
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
        private EditText etBet;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);

            etBet = (EditText) itemView.findViewById(R.id.etBet);
            etBet.addTextChangedListener(twBet);
        }

        private TextWatcher twBet = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {

                    //get the bet
                    int bet = Integer.parseInt(s.toString());

                    //check if we bet more than the cards we have
                    if (bet > game.getCurrentCards()) {

                        //the bet is equals to the cards we have
                        bet = game.getCurrentCards();

                        //change the edit text
                        etBet.removeTextChangedListener(twBet);
                        etBet.setText(String.valueOf(bet));
                        etBet.setSelection(etBet.getText().length());
                        etBet.addTextChangedListener(twBet);

                    }

                    //update the bets of the player
                    Player player = game.getBetPlayer(getAdapterPosition());
                    player.setBet(bet);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

}
