package com.glacial.p0x4.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.fragments.ProfilePlayersFragment;
import com.glacial.p0x4.general.UtilsFragments;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvTBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        initValues();

        UtilsFragments.start(this, ProfilePlayersFragment.newInstance(), ProfilePlayersFragment.TAG);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViews() {
        tvTBarTitle = (TextView) this.findViewById(R.id.tvTBarTitle);
    }

    private void initValues() {
        tvTBarTitle.setText(R.string.profile_title);
    }

}
