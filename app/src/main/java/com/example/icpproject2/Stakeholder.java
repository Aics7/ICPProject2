package com.example.icpproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Stakeholder extends AppCompatActivity {

    public  static String userName = "";

    public static ArrayList<String> stakeHolderAccounts =new ArrayList<String>();
    public static ArrayList<String> stakeHolderAccountnames =new ArrayList<String>();
    public static ArrayList<String> stakeHolderPassword =new ArrayList<String>();



    TextView stakeHolderName;
    Button showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stake_holder);

        stakeHolderName = (TextView) findViewById(R.id.stakeHolderName);

        stakeHolderName.setText(userName);

    }

    public void showUserData(View view){
        Intent int1=new Intent(Stakeholder.this,AccountsData.class);
        startActivity(int1);
    }

    public void logOutStakeholder(View view){
        Intent int1=new Intent(Stakeholder.this,CreateAccount.class);
        startActivity(int1);
    }
}
