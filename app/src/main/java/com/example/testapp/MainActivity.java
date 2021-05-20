package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import static android.view.KeyEvent.KEYCODE_L;
import static android.view.KeyEvent.META_ALT_MASK;
import static android.view.KeyEvent.META_ALT_ON;
import static android.view.KeyEvent.META_CTRL_MASK;
import static android.view.KeyEvent.META_CTRL_ON;
import static android.view.KeyEvent.META_META_MASK;
import static android.view.KeyEvent.META_META_ON;
import static android.view.KeyEvent.META_SHIFT_MASK;
import static android.view.KeyEvent.META_SHIFT_ON;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.civ_logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CombinationViewAct.class);
                startActivity(intent);
            }
        });
    }
}