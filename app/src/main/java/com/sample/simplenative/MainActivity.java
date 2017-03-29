package com.sample.simplenative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.ads.*;

public class MainActivity extends AppCompatActivity
    implements InterstitialAdListener {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the interstitial
        interstitialAd = new InterstitialAd(this, getString(R.string.placement_id_interstitial));
        interstitialAd.setAdListener(this);
        interstitialAd.loadAd();

        // Add trigger to show the interstitial ad
        Button showInterstitial = (Button)findViewById(R.id.show_interstitial);
        showInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd != null) {
                    if (interstitialAd.isAdLoaded()) {
                        interstitialAd.show();
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }

    // InterstitialAdListener implementations
    @Override
    public void onInterstitialDisplayed(Ad ad) {
        // Interstitial displayed callback
    }

    @Override
    public void onInterstitialDismissed(Ad ad) {
        // Interstitial dismissed callback
    }

    @Override
    public void onError(Ad ad, AdError adError) {
        // Ad error callback
        Toast.makeText(MainActivity.this, "Error: " + adError.getErrorMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdLoaded(Ad ad) {
        Toast.makeText(MainActivity.this, "Ad loaded!",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdClicked(Ad ad) {
        // Ad clicked callback
    }

}
