package com.elexandro.openplaystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openPlayStore = findViewById(R.id.button_open_play_store);
        openPlayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayStore();
            }
        });
    }

    private void openPlayStore() {
        String appPackageName = "com.google.android.youtube";
        Intent playStoreAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
        Intent playStoreSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName));

        try {
            startActivity(playStoreAppIntent);
        } catch (Exception exception) {
            startActivity(playStoreSiteIntent);
        }
    }
}