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

        int highest=0;
        int index=0;
        for(int i:MakePayment.bottlesScanned){
            if (i>highest){highest=index;}
            index++;
        }
        if(highest>=0){
            String guardian=MakePayment.accountnames.get(highest);
            TextView newTextView=(TextView) findViewById(R.id.guardName);
            newTextView.setText(guardian);
        }
        else{
            TextView newTextView=(TextView) findViewById(R.id.guardName);
            String guardian= "No users available";
            newTextView.setText(guardian);
        }

    }
}
