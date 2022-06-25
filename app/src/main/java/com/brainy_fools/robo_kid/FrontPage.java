package com.brainy_fools.robo_kid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.brainy_fools.robo_kid.databinding.ActivityFrontPageBinding;

public class FrontPage extends AppCompatActivity {

    private FrontPage frontpageBinding;
    ActivityFrontPageBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        binding = ActivityFrontPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initial Fragment when first view
        replaceFragment(new HomeFragment());

        Toolbar toolbar = findViewById(R.id.frontpage_toolbar);
        setSupportActionBar(toolbar);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_icon:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.renew_icon:
                    replaceFragment(new LiveFootageFragment());
                    break;
                case R.id.settings_icon:
                    replaceFragment(new AboutFragment());
                    break;
                case R.id.camera_icon:
                    replaceFragment(new EmbeddedFragment());
                    break;
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_Layout, fragment);
        fragmentTransaction.commit();
    }

    public void share_this_app(View view) {
        Toast.makeText(getApplicationContext(),"Share option coming...", Toast.LENGTH_SHORT).show();
    }
}
