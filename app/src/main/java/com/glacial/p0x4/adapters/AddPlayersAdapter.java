package com.glacial.p0x4.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Game;

/**
 * Created by dacuesta on 1/9/16.
 */
public class AddPlayersAdapter extends RecyclerView.Adapter<AddPlayersAdapter.ViewHolder> {

    private Game game;
    private FragmentActivity activity;

    public AddPlayersAdapter(Game game, FragmentActivity activity) {
        this.game = game;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_new_player, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //player
        if (position < game.getNumPlayers()) {

            //disable edit text
            holder.etPlayer.setEnabled(false);

            //set text to edit text
            holder.etPlayer.setText(game.getPlayer(position).getName());

            //show remove button
            holder.bAdd.setVisibility(View.GONE);
            holder.bRemove.setVisibility(View.VISIBLE);

        }

        //item to add player
        else {

            //enable edit button
            holder.etPlayer.setEnabled(true);

            //empty edit text
            holder.etPlayer.setText("");

            //show add button
            holder.bAdd.setVisibility(View.VISIBLE);
            holder.bRemove.setVisibility(View.GONE);

            holder.etPlayer.requestFocus();
        }
    }

    @Override
    public int getItemCount() {
        return game.getNumPlayers() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, TextView.OnEditorActionListener {

        public EditText etPlayer;
        private Button bAdd, bRemove;

        public ViewHolder(View itemView) {
            super(itemView);

            //edit text
            etPlayer = (EditText) itemView.findViewById(R.id.etPlayer);
            etPlayer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) etPlayer.setBackgroundResource(R.drawable.p0x4_edit_text_selected);
                    else etPlayer.setBackgroundResource(R.drawable.p0x4_edit_text_default);
                }
            });
            etPlayer.setOnEditorActionListener(this);

            //add button
            bAdd = (Button) itemView.findViewById(R.id.bAdd);
            bAdd.setOnClickListener(this);

            //remove button
            bRemove = (Button) itemView.findViewById(R.id.bRemove);
            bRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.bAdd:
                    addPlayer(etPlayer);
                    break;

                case R.id.bRemove:

                    //remove player from the gmae
                    game.removePlayer(getAdapterPosition());

                    AddPlayersAdapter.this.notifyDataSetChanged();

                    break;

            }
        }

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (v.getId()) {
                case R.id.etPlayer:
                    if (actionId == EditorInfo.IME_ACTION_DONE)
                        addPlayer(etPlayer);
            }

            return true;
        }

        /**
         * Add player to the game if EditText is filled
         * @param et
         */
        private void addPlayer(EditText et) {
            if (game.addPlayer(etPlayer.getText().toString())) {
                AddPlayersAdapter.this.notifyDataSetChanged();
            }
        }
    }

}
