package com.Pay.cash.Advance.Insta.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.Pay.cash.Advance.Insta.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class SignUpActivity extends AppCompatActivity {

    private static ProgressDialog pd;
    private EditText firstName,lastName,email,phone,password,verifiedPassword;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName=findViewById(R.id.first_name_edittext);
        lastName=findViewById(R.id.last_name_edittext);
        email=findViewById(R.id.email_edittext);
        phone=findViewById(R.id.phone_edittext);
        password=findViewById(R.id.password_edittext);
        verifiedPassword=findViewById(R.id.re_enter_password_edittext);
    }

    public void onCreateAccount(View view) {
        String first= firstName.getText().toString().trim();
        String last = lastName.getText().toString().trim();
        String emailString=email.getText().toString().trim();
        String phoneNumber=phone.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String verifiedPass=verifiedPassword.getText().toString().trim();
        if(!first.isEmpty() && !last.isEmpty() && !emailString.isEmpty()
                && !phoneNumber.isEmpty() && !pass.isEmpty() && !verifiedPass.isEmpty()){
            if(!emailString.contains("@") || !emailString.contains(".")){
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
           return;
            }
            if(!verifiedPass.equals(pass)){
                Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
           verifiedPassword.setText("");
           return;
            }
            SharedPreferences pfs = getSharedPreferences(getString(R.string.myPreferences),MODE_PRIVATE);
            SharedPreferences.Editor editor = pfs.edit();
            editor.putString(getString(R.string.firstName),first);
            editor.putString(getString(R.string.lastName),last);
            editor.putString(getString(R.string.emailKey),emailString);
            editor.putString(getString(R.string.phoneNumber),phoneNumber);
            editor.putString(getString(R.string.password),pass);
            editor.apply();
            showAd();
        }else{
            Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show();
        }



        //startActivity(new Intent(this,IdentificationDetailsActivity.class));

    }

    private void showAd(){
       // pd = ProgressDialog.show(this, "", "loading...", true, false);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        startActivity(new Intent(SignUpActivity.this,IdentificationDetailsActivity.class));
        //MobileAds.initialize(this, getString(R.string.admob_app_id));
        /*interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.activity_interstitial_ad_id));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                pd.dismiss();
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                pd.dismiss();
                startActivity(new Intent(SignUpActivity.this,IdentificationDetailsActivity.class));

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(SignUpActivity.this,IdentificationDetailsActivity.class));

            }
        });*/
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    public void onAlreadyMemberClicked(View view) {
       // pd = ProgressDialog.show(this, "", "Loading...", true, false);
       /* MobileAds.initialize(this, getString(R.string.activity_interstitial_ad_id));
        ad = new InterstitialAd(this);
        ad.setAdUnitId(getString(R.string.activity_interstitial_ad_id));
        ad.loadAd(new AdRequest.Builder().build());
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                pd.dismiss();
                ad.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                pd.dismiss();
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));

            }
        });*/
        //startActivity(new Intent(this,SignInActivity.class));

        startActivity(new Intent(SignUpActivity.this,SignInActivity.class));

    }
}
