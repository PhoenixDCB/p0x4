package com.glacial.p0x4.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.core.Profile;
import com.glacial.p0x4.core.ProfilePlayer;

/**
 * Created by dacuesta on 3/1/17.
 */

public class ProfilePlayersAdapter extends RecyclerView.Adapter<ProfilePlayersAdapter.ProfilePlayerViewHolder> {

    static class ProfilePlayerViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAvatar;
        private TextView tvName;
        private TextView tvTotalMatchesPlayed;
        private TextView tvTotalMatchesWon;

        public ProfilePlayerViewHolder(View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View itemView) {
            ivAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvTotalMatchesPlayed = (TextView) itemView.findViewById(R.id.tvTotalMathesPlayed);
            tvTotalMatchesWon = (TextView) itemView.findViewById(R.id.tvTotalMatchesWon);
        }
    }

    private Fragment fragment;
    private Profile profile;

    public ProfilePlayersAdapter(Fragment fragment, Profile porfile) {
        this.fragment = fragment;
        this.profile = porfile;
    }

    @Override
    public ProfilePlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_profile_player, parent, false);
        ProfilePlayerViewHolder holder = new ProfilePlayerViewHolder(itemView);
        return holder;
    }

    @Override
    public int getItemCount() {
        return profile.getPlayers().size();
    }

    @Override
    public void onBindViewHolder(ProfilePlayerViewHolder holder, int position) {
        ProfilePlayer player = profile.getPlayers().get(position);

        holder.tvName.setText(fragment.getString(R.string.profile_name).replaceFirst("#", String.valueOf(player.getName())));
        holder.tvTotalMatchesPlayed.setText(fragment.getString(R.string.profile_total_matches_played).replaceFirst("#", String.valueOf(player.getTotalMatchesPlayed())));
        holder.tvTotalMatchesWon.setText(fragment.getString(R.string.profile_total_matches_won).replaceFirst("#", String.valueOf(player.getTotalMatchesWon())));
    }

}
