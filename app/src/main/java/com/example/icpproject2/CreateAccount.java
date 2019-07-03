package com.example.icpproject2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    private EditText userName,mail, password;
    FirebaseAuth authUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        password = (EditText) findViewById(R.id.password);
        mail = (EditText) findViewById(R.id.email);
        userName = (EditText) findViewById(R.id.userName);

        authUser = FirebaseAuth.getInstance();
    }

    public void create(View view){


        if(mail.getText().toString().equals("") && password.getText().toString().equals("")){
            Toast.makeText(this, "Provide email & password", Toast.LENGTH_SHORT).show();
        }else {

            String eeemail = mail.getText().toString();
            String passssword = password.getText().toString();
            String name = userName.getText().toString();

                authUser.createUserWithEmailAndPassword(eeemail,passssword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "Collector Sign-up Complete", Toast.LENGTH_SHORT).show();
                                    finish();

                                    MakePayment.accounts.add(mail.getText().toString());
                                    MakePayment.balance.add(0.00);
                                    MakePayment.password.add(password.getText().toString());
                                    MakePayment.accountnames.add(userName.getText().toString());
                                    MakePayment.bottlesScanned.add(0);
                                    Intent int11=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int11);

                                }else {
                                    Toast.makeText(CreateAccount.this, "Collector Couldn't Sign-up", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



        }

    }

    public void login(View view) {

        if(mail.getText().toString().equals("") && password.getText().toString().equals("")) {
            Toast.makeText(this, "Provide email & password", Toast.LENGTH_SHORT).show();
        }else {

            String eeemial = mail.getText().toString();
            String paaassword = password.getText().toString();
            String name = userName.getText().toString();



                authUser.signInWithEmailAndPassword(eeemial,paaassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "User Log-in Complete", Toast.LENGTH_SHORT).show();
                                    finish();
                                    MakePayment.accounts.add(mail.getText().toString());
                                    MakePayment.balance.add(0.00);
                                    MakePayment.password.add(password.getText().toString());
                                    MakePayment.accountnames.add(userName.getText().toString());
                                    MakePayment.bottlesScanned.add(0);
                                    // open new screen here
                                    Intent int1=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int1);
                                }else {
                                    Toast.makeText(CreateAccount.this, "User Couldn't Log-in", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

        }

    }
}
