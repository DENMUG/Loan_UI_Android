package com.Pay.cash.Advance.Insta.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.Pay.cash.Advance.Insta.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



public class RateActivity extends AppCompatActivity {

    private boolean shouldReloadAd = true;
    private static ProgressDialog pd;


    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

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
        /*mAdView = findViewById(R.id.adView);
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
    public void decline(View view){
        //pd = ProgressDialog.show(this, "", "exiting...", true, false);
        startActivity(new Intent(RateActivity.this,LoanDetailActivity.class));
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
                startActivity(new Intent(RateActivity.this,LoanDetailActivity.class));

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
                startActivity(new Intent(RateActivity.this,LoanDetailActivity.class));

            }
        });*/
        //startActivity(new Intent(this,LoanDetailActivity.class));

    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    public void rateUs(View view){
       // pd = ProgressDialog.show(this, "", "Loading...", true, false);
       // MobileAds.initialize(this, getString(R.string.admob_app_id));
       /* ad = new InterstitialAd(this);
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
                //startActivity(new Intent(TermsActivity.this,SignInActivity.class));

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
               // startActivity(new Intent(TermsActivity.this,SignInActivity.class));

            }
        });*/
    }
}
