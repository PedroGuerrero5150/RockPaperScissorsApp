package com.example.proyecto5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto5.util.HistoryTracker;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button b_History;
    private ImageButton b_Rock, b_Paper, b_Scissors;
    private ImageView iv_PlayerChoice, iv_ComputerChoice;
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "com.example.proyecto5.extra.MESSAGE";
    private HistoryTracker mHistoryTracker = HistoryTracker.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Id assignments
        b_History = findViewById(R.id.button_History);
        b_Rock =  findViewById(R.id.Button_Rock);
        b_Paper = findViewById(R.id.Button_Paper);
        b_Scissors = findViewById(R.id.Button_Scissors);
        iv_PlayerChoice = findViewById(R.id.imageView_PlayerChoice);
        iv_ComputerChoice = findViewById(R.id.imageView_ComputerChoice);

        //Buttons listeners declarations
        b_History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHistoryActivity ();
            }
        });

        b_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_PlayerChoice.setImageResource(R.drawable.rock);
                launchWinnerDrawActivity(computerTurn("rock"));
            }
        });

        b_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_PlayerChoice.setImageResource(R.drawable.paper);
                launchWinnerDrawActivity(computerTurn("paper"));
            }
        });

        b_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_PlayerChoice.setImageResource(R.drawable.scissors);
                launchWinnerDrawActivity(computerTurn("scissors"));
            }
        });

    }

    public String computerTurn(String playerChoice) {
        Random r = new Random();
        String computerChoice;
        String result;

        int randomNumber = r.nextInt(3) + 1;

        //assign random play
        if(randomNumber == 1) {
            computerChoice = "rock";
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }
        else if (randomNumber == 2) {
            computerChoice = "paper";
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }
        else {
            computerChoice = "scissors";
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }

        //verify winner
        if(playerChoice.equals(computerChoice)) {
            Log.i(TAG, "computerTurn() = draw ");
            result = "draw";
        }
        else if (playerChoice.equals("rock") && computerChoice.equals("scissors") ||
                playerChoice.equals("scissors") && computerChoice.equals("paper") ||
                playerChoice.equals("paper") && computerChoice.equals("rock")){
            result = "win";
        }
        else {
            result = "lose";
        }

        //escribir historico en singletone
        mHistoryTracker.setHistoryList(playerChoice, computerChoice, result);

        return result;
    }


    public void launchWinnerDrawActivity(String result){
        Intent intent = new Intent(this, WinnerDraw_Activity.class);
        intent.putExtra(EXTRA_MESSAGE, result);

        //demorar un segundo para ver jugadas
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(intent);
            }
        }, 1000);
    }

    public void launchHistoryActivity (){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}