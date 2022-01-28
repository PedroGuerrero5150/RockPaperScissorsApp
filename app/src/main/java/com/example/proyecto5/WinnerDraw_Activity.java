package com.example.proyecto5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WinnerDraw_Activity extends AppCompatActivity {

    private ImageView iv_WinnerDraw;
    private Button b_playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_draw);

        //intent communications
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //UI elements id assigments
        iv_WinnerDraw = findViewById(R.id.imageView_WinnerDraw);
        b_playAgain = findViewById(R.id.Button_PlayAgain);

        //Buttons listeners declarations
        b_playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //set winner image
        if (message.equals("win"))
            iv_WinnerDraw.setImageResource(R.drawable.you_win);
        else if (message.equals("lose"))
        iv_WinnerDraw.setImageResource(R.drawable.you_lose);
        else
            iv_WinnerDraw.setImageResource(R.drawable.tie);


    }
}