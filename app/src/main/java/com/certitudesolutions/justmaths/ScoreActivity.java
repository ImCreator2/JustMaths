package com.certitudesolutions.justmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    ImageButton bthReplay, btnShare, btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView tv = findViewById(R.id.score);
        int score = getIntent().getIntExtra("score", 0);
        tv.setText("Current Score : " + score);

        bthReplay = findViewById(R.id.replayBtn);
        bthReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

        btnShare = findViewById(R.id.shareBtn);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 *  Example of Implict Intent
                 *  When you click Share Button on the screen
                 *  Android will find the activities that allow to share messages.
                 */

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Just Maths - Fun way to learn Maths. http://www.play.google.com");
                startActivity(intent);
            }
        });

        btnRate = findViewById(R.id.rateBtn);
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 *  Simple Toast Message To Display Message For Short Duration
                 *  Link that to your app landing page.
                 */
                Toast.makeText(ScoreActivity.this,"You can open your Google Play landing page",Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
