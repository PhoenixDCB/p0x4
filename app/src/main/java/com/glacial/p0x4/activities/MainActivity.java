package com.glacial.p0x4.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.glacial.p0x4.R;
import com.glacial.p0x4.general.UtilsFragments;

public class MainActivity extends AppCompatActivity {

    private TextView tvTBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvTBarTitle = (TextView) this.findViewById(R.id.tvTBarTitle);

        UtilsFragments.start(getSupportFragmentManager());
    }

     @Override
     public void onBackPressed() {
        super.onBackPressed();

        UtilsFragments.goBack();
     }

    public TextView getTvTBarTitle() {
        return tvTBarTitle;
    }
}
