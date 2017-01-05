package com.glacial.p0x4.application;

import android.app.Application;

import com.glacial.p0x4.core.Profile;

/**
 * Created by dacuesta on 3/1/17.
 */

public class GlacialApplication extends Application {

    private Profile profile;

    @Override
    public void onCreate() {
        super.onCreate();

        profile = new Profile();
    }

    public Profile getProfile() {
        return profile;
    }
}
