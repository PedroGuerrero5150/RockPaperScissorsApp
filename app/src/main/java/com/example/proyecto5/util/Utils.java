package com.example.proyecto5.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

public class Utils {
    //instancia singletone
    private static HistoryTracker mHistoryTracker = HistoryTracker.getInstance();

    public static void printHistory(final TextView viewHistory) {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                // Get the stack of Activity lifecycle methods called and print to TextView
                StringBuilder sbHistory = new StringBuilder();
                List<String> listHistory = mHistoryTracker.getMethodList();
                for (String h : listHistory) {
                    sbHistory.insert(0, h + "\r\n");
                }
                if(viewHistory != null) {
                    viewHistory.setText(sbHistory.toString());
                }

            }
        }, 500);
    }

}
