package com.brainy_fools.robo_kid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class OnBoarding extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_on_boarding);

        fragmentManager = getSupportFragmentManager();

        PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getElementsForOnBoardingFragment());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container_for_onBoarding, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                startActivity(new Intent(getApplicationContext(), SendOTP.class));
                finish();  // finishing current activity here
            }
        });

//        startActivity(new Intent(getApplicationContext(), FrontPage.class));
//        finish();
    }

    private ArrayList<PaperOnboardingPage> getElementsForOnBoardingFragment() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("About",
                "I was destined to be a supervillain, and we were destined to be rivals!",
                Color.parseColor("#F8FFFD"), R.drawable.rsz_robo_3, R.drawable.robo_smile);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Features",
                "I may not know much but I do know this the bad guy doesn't get the girl.",
                Color.parseColor("#E9CFEB"), R.drawable.robo_2, R.drawable.robo_family);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Technology",
                "I'm so tired of running rampant through the streets. What's the point of being bad when there's no good to try and stop you?",
                Color.parseColor("#ffffff"), R.drawable.rsz_robo_1, R.drawable.robo_tech);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        return elements;
    }
}
