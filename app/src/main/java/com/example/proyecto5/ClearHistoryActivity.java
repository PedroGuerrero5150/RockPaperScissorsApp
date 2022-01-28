package com.example.proyecto5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto5.util.HistoryTracker;
import com.example.proyecto5.util.Utils;

public class ClearHistoryActivity extends AppCompatActivity {

    Button b_confirmClearHistory;
    private HistoryTracker mHistoryTracker = HistoryTracker.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clear_history_activity);

        //UI elements id assigments
        b_confirmClearHistory = findViewById(R.id.button_ClearHistoryConfirmation);

        //button handlers
        b_confirmClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHistoryTracker.clear();
                finish();
            }
        });

    }
}