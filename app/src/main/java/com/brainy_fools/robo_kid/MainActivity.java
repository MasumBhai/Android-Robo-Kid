package com.brainy_fools.robo_kid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }
    public void  openActivity2(){
        Intent intent = new Intent(this, SendOTP.class);
        startActivity(intent);
    }

    /*todo: need to change...or omit
    DashBoard, MainActivity, SendOTP, VerifyOTP
    activity_dashboard, activity_main, activity_send_otp, activity_verify_otp


     */
}