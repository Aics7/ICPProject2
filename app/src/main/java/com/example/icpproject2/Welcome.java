package com.example.icpproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void Collector(View view){
        Intent int1=new Intent(Welcome.this,CreateAccount.class);
        startActivity(int1);
    }

    public void Stakeholder(View view){
        Intent int1=new Intent(Welcome.this,SignIn.class);
        startActivity(int1);
    }
    public void Guest(View view){
        Intent int1=new Intent(Welcome.this,About.class);
        startActivity(int1);
    }

}
