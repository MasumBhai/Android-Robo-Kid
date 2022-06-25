package com.brainy_fools.robo_kid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class StarterActivity extends AppCompatActivity {
    public static final int SplashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(SplashTime);
                    startActivity(new Intent(getApplicationContext(), FrontPage.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        splashTread.start();
    }
}