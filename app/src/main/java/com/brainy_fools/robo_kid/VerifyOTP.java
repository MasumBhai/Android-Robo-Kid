package com.brainy_fools.robo_kid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;

public class VerifyOTP extends AppCompatActivity {

    private EditText inputCode;
    private Button verifyOTPBtn;
    private String phoneNumber, verfiedID, generatedOTP, resendToken;

    private FirebaseAuth mAuth;

    @SuppressLint({"MissingInflatedId", "SourceLockedOrientationActivity"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // verifyOTP class is not needed for this project...i didn't call it anywhere actually
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_verify_otp);

        mAuth = FirebaseAuth.getInstance();
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        generatedOTP = getIntent().getStringExtra("resendOTP"); //todo: change
        verfiedID = getIntent().getStringExtra("verificationID");
        resendToken = getIntent().getStringExtra("mResendToken");

        TextView textMobile = findViewById(R.id.textMobile);
        textMobile.setText(phoneNumber);

        inputCode = findViewById(R.id.inputOTPCode);
        inputCode.setText(generatedOTP);

        verifyOTPBtn.setOnClickListener(view -> verifyCode(verfiedID, generatedOTP));
    }


    private void verifyCode(String id, String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(id, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(getApplicationContext(), FrontPage.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}