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



public class SignInActivity extends AppCompatActivity {

    private boolean shouldReloadAd=true;
    private static ProgressDialog pd;

    private EditText email,password;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

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
       /* mAdView = findViewById(R.id.adView);
        email=findViewById(R.id.email_edittext);
        password=findViewById(R.id.password_edittext);
        SharedPreferences pfs = getSharedPreferences(getString(R.string.myPreferences),MODE_PRIVATE);
       String emailString = pfs.getString(getString(R.string.emailKey),"");
       String passwordString = pfs.getString(getString(R.string.password),"");
       if(!emailString.isEmpty() && !passwordString.isEmpty()){
           email.setText(emailString);
           password.setText(passwordString);
       }else{
           Toast.makeText(this, "Please sign up first", Toast.LENGTH_SHORT).show();
       }
        MobileAds.initialize(this, getString(R.string.activity_interstitial_ad_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                if(errorCode== ERROR_CODE_NETWORK_ERROR){

                    if(shouldReloadAd) {
                        AdRequest adRequest = new AdRequest.Builder().build();
                        mAdView.loadAd(adRequest);
                        shouldReloadAd = !shouldReloadAd;
                    }
                }
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });*/
    }
    public void noAccountYet(View view){
        //pd = ProgressDialog.show(this, "", "Loading...", true, false);

        startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
       // MobileAds.initialize(this, getString(R.string.admob_app_id));
       /* interstitialAd = new InterstitialAd(this);
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
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));

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
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));

            }
        });*/
       // startActivity(new Intent(this,SignUpActivity.class));
    }
    public void login(View view){
        SharedPreferences pfs = getSharedPreferences(getString(R.string.myPreferences),MODE_PRIVATE);
        String emailString = pfs.getString(getString(R.string.emailKey),"");
        String passwordString = pfs.getString(getString(R.string.password),"");
        if(emailString.isEmpty() || passwordString.isEmpty()){
            Toast.makeText(this, "Please sign up first", Toast.LENGTH_SHORT).show();
        }else{
            if(emailString.equals(email.getText().toString().trim()) &&
                    passwordString.equals(password.getText().toString().trim())){
                showAd();
            }else{
                Toast.makeText(this, "Login information entered is incorrect!", Toast.LENGTH_SHORT).show();
            }
        }
       // startActivity(new Intent(this,IdentificationDetailsActivity.class));
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    private void showAd(){
       // pd = ProgressDialog.show(this, "", "Loading...", true, false);
        startActivity(new Intent(SignInActivity.this,IdentificationDetailsActivity.class));
      /*  MobileAds.initialize(this, getString(R.string.activity_interstitial_ad_id));
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
                startActivity(new Intent(SignInActivity.this,IdentificationDetailsActivity.class));

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
                startActivity(new Intent(SignInActivity.this,IdentificationDetailsActivity.class));

            }
        });*/
    }
}
