package com.example.proyecto5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyecto5.util.Utils;

public class HistoryActivity extends AppCompatActivity {

    Button b_ClearHistory;
    private TextView tv_historyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //UI elements id assigments
        b_ClearHistory = findViewById(R.id.button_ClearHistory);
        tv_historyView = findViewById(R.id.textView_History);

        //imprimir historico
        Utils.printHistory(tv_historyView);

        //button handlers
        b_ClearHistory .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchClearHistoryActivity ();
            }
        });
    }

    //actualizar gui cuando se borra historico
    @Override
    public void onResume(){
        super.onResume();
        Utils.printHistory(tv_historyView);
    }


    public void launchClearHistoryActivity (){
        Intent intent = new Intent(this, ClearHistoryActivity.class);
        startActivity(intent);
    }

}