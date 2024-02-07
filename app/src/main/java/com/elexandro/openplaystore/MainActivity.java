package com.elexandro.openplaystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<String> packageNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageNames = new ArrayList<>();
        packageNames.add("com.google.android.youtube");
        packageNames.add("org.wikipedia");
        packageNames.add("com.mojang.minecraftpe");
        packageNames.add("com.king.candycrushsaga");

        Button openPlayStore = findViewById(R.id.button_open_play_store);
        openPlayStore.setOnClickListener(view -> openPlayStore());
    }

    private void openPlayStore() {
        Random random = new Random();
        int index = random.nextInt(packageNames.size());
        String packageName = packageNames.get(index);

        Intent playStoreAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
        Intent playStoreSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));

        try {
            startActivity(playStoreAppIntent);
        } catch (Exception exception) {
            startActivity(playStoreSiteIntent);
        }
    }
}