package com.example.icpproject2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {


    private EditText mail, password;
    FirebaseAuth authUser;

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        password = (EditText) findViewById(R.id.password);
        mail = (EditText) findViewById(R.id.email);

        radioGroup = findViewById(R.id.groupRadio);
        authUser = FirebaseAuth.getInstance();
    }

    public void create(View view){
        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        if(mail.getText().toString().equals("") && password.getText().toString().equals("")){
            Toast.makeText(this, "Provide email & password", Toast.LENGTH_SHORT).show();
        }else {

            String eeemail = mail.getText().toString();
            String passssword = password.getText().toString();

            if(radioButton == null){

                Toast.makeText(this, "Couldn't create account", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Select User/Stakeholder", Toast.LENGTH_SHORT).show();


            }else if (radioButton.getText().toString().equals("User")){

                authUser.createUserWithEmailAndPassword(eeemail,passssword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "User Sign-up Complete", Toast.LENGTH_SHORT).show();
                                    finish();

                                    Intent int1=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int1);
                                }else {
                                    Toast.makeText(CreateAccount.this, "User Couldn't Sign-up", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else if(radioButton.getText().equals("Stakeholder")) {

                authUser.createUserWithEmailAndPassword(eeemail,passssword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "Stakeholder Sign-up Complete", Toast.LENGTH_SHORT).show();
                                    finish();

                                    Intent int1=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int1);
                                }else {
                                    Toast.makeText(CreateAccount.this, "Stakeholder Couldn't Sign-up", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }

        }

    }

    public void login(View view) {

        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        if(mail.getText().toString().equals("") && password.getText().toString().equals("")) {
            Toast.makeText(this, "Provide email & password", Toast.LENGTH_SHORT).show();
        }else {

            String eeemial = mail.getText().toString();
            String paaassword = password.getText().toString();


            if(radioButton == null){
                Toast.makeText(this, "Couldn't Log-in", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Select User/Stakeholder", Toast.LENGTH_SHORT).show();

            }else if (radioButton.getText().toString().equals("User")){

                authUser.signInWithEmailAndPassword(eeemial,paaassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "User Log-in Complete", Toast.LENGTH_SHORT).show();
                                    finish();
                                    // open new screen here
                                    Intent int1=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int1);
                                }else {
                                    Toast.makeText(CreateAccount.this, "User Couldn't Log-in", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }else if(radioButton.getText().equals("Stakeholder")) {
                authUser.signInWithEmailAndPassword(eeemial,paaassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CreateAccount.this, "Stakeholder Log-in Complete", Toast.LENGTH_SHORT).show();
                                    finish();
                                    // open new screen here
                                    Intent int1=new Intent(CreateAccount.this,MainActivity.class);
                                    startActivity(int1);
                                }else {
                                    Toast.makeText(CreateAccount.this, "Stakeholder Couldn't Log-in", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CreateAccount.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }

        }

    }
}
