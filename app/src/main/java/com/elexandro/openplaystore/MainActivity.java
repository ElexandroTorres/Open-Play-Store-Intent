package com.elexandro.openplaystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openYoutube = findViewById(R.id.button_youtube);
        Button openWikipedia = findViewById(R.id.button_wikipedia);
        Button openMfcSascar = findViewById(R.id.button_mfc_sascar);

        openYoutube.setOnClickListener(view -> openPlayStore("com.google.android.youtube"));
        openWikipedia.setOnClickListener(view -> openPlayStore("org.wikipedia"));
        openMfcSascar.setOnClickListener(view -> openPlayStore("br.com.mfcsascar"));
    }

    private void openPlayStore(String packageName) {
        Intent playStoreAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
        playStoreAppIntent.setPackage("com.android.vending");
        Intent playStoreSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));

        try {
            startActivity(playStoreAppIntent);
        } catch (Exception exception) {
            startActivity(playStoreSiteIntent);
        }
    }
}

