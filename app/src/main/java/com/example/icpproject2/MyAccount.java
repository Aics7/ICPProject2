package com.example.icpproject2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity {

    String name=MainActivity.userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        int index=MakePayment.accountnames.indexOf(name);

        TextView userName = (TextView) findViewById(R.id.na);
        userName.setText(MakePayment.accountnames.get(index));

        TextView email = (TextView) findViewById(R.id.em);
        email.setText(MakePayment.accountnames.get(index));

        TextView binStatus = (TextView) findViewById(R.id.bin);
        binStatus.setText(MakePayment.accountnames.get(index)+ "/ 5" );

        TextView balance = (TextView) findViewById(R.id.bal);
        balance.setText("GHc "+MakePayment.accountnames.get(index));
    }

}
