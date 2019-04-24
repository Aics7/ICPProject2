package com.example.icpproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void create(View view){

        EditText edit1 = (EditText) findViewById(R.id.email);
        String email = edit1.getText().toString();
        EditText edit2 = (EditText) findViewById(R.id.password);
        String password=edit2.getText().toString();

        if(MakePayment.accounts.indexOf(email)!=-1){
            Toast.makeText(getApplicationContext(), "Account already Exists", Toast.LENGTH_LONG).show();

            Intent int1=new Intent(CreateAccount.this,MainActivity.class);
            startActivity(int1);
        }
        else if(email.length()>=12 && password.length()>=8){
            MakePayment.accounts.add(email);
            MakePayment.password.add(password);
            MakePayment.balance.add(0.00);
            Toast.makeText(getApplicationContext(), "Account created Successfully", Toast.LENGTH_LONG).show();

            Intent int1=new Intent(CreateAccount.this,MainActivity.class);
            startActivity(int1);
        }
        else if(email.length()<10){
            Toast.makeText(getApplicationContext(), "Email length is below standard", Toast.LENGTH_LONG).show();
        }
        else if(password.length()<8){
            Toast.makeText(getApplicationContext(), "Password must be 8 characters or more", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Both email and password are required to create an account", Toast.LENGTH_LONG).show();
        }
    }

    public void login(View view) {

        EditText edit1 = (EditText) findViewById(R.id.email);
        String email = edit1.getText().toString();
        EditText edit2 = (EditText) findViewById(R.id.password);
        String password = edit2.getText().toString();

        Intent int1=new Intent(CreateAccount.this,MainActivity.class);
        startActivity(int1);

    }
}
