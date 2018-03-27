package com.example.user.samallanimationproject;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by User on 3/15/2018.
 */

public class SplashScreen extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash) {

        configSplash.setLogoSplash(R.mipmap.ic_launcher_round);
        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);


        configSplash.setOriginalHeight(400);
        configSplash.setOriginalWidth(400);
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3);
        configSplash.setPathSplashStrokeColor(R.color.colorAccent);
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.colorWhite);


        configSplash.setTitleSplash("Developed by Mehedi ");
        configSplash.setTitleTextColor(R.color.colorWhite);
        configSplash.setTitleTextSize(20f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);
    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(SplashScreen.this,MainActivity.class));
    }
}
