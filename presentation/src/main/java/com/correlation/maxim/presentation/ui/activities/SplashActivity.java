package com.correlation.maxim.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by max on 6/18/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openMatrixRepresentationActivity();
    }

    private void openMatrixRepresentationActivity() {
        Intent intent = new Intent(this, MatrixRepresentationActivity.class);
        startActivity(intent);
        finish();
    }
}
