package com.example.icpproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Collections;

public class LeaderBoad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_boad);


        if (MakePayment.bottlesScanned.size() > 0) {
            int highest=Collections.max(MakePayment.bottlesScanned);
            String guardian=MakePayment.accountnames.get(highest);
            TextView newTextView=(TextView) findViewById(R.id.guardName);
            newTextView.setText(guardian);
        }
        else{
            TextView newTextView=(TextView) findViewById(R.id.guardName);
            newTextView.setText("No Users available");
        }
    }
}
