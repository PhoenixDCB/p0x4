package com.glacial.p0x4.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.glacial.p0x4.R;
import com.glacial.p0x4.general.UtilsFragments;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UtilsFragments.start(getSupportFragmentManager());
    }

     @Override
     public void onBackPressed() {
        super.onBackPressed();

        UtilsFragments.goBack();
     }
}
