package com.azati.sample50;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Data data = new Data();

        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);

    }
}