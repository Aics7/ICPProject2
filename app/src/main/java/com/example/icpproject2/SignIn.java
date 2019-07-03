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

public class SignIn extends AppCompatActivity {


    private EditText userName,mail, password;
    FirebaseAuth authUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        password = (EditText) findViewById(R.id.passwordS);
        mail = (EditText) findViewById(R.id.emailS);
        userName = (EditText) findViewById(R.id.userNameS);

        authUser = FirebaseAuth.getInstance();
    }


    public void login(View view) {


        if(mail.getText().toString().equals("") && password.getText().toString().equals("")) {
            Toast.makeText(this, "Provide email & password", Toast.LENGTH_SHORT).show();
        }else {

            String eeemial = mail.getText().toString();
            String paaassword = password.getText().toString();
            String name = userName.getText().toString();

                String zoomName = "Zoomlion";
                String zoomMial = "zoomlion@zoomlionghana.com";

                String zoomPassword = "zoomlionGhana";

                if ((zoomMial.equals(eeemial)) && (zoomPassword.equals(paaassword))&& name.equalsIgnoreCase("zoomlion") ) {
                    authUser.signInWithEmailAndPassword(zoomMial, zoomPassword)

                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignIn.this, "Stakeholder Log-in Complete", Toast.LENGTH_SHORT).show();
                                        finish();
                                        // open new screen here
                                        Intent int1 = new Intent(SignIn.this, Stakeholder.class);
                                        startActivity(int1);
                                    } else {
                                        Toast.makeText(SignIn.this, "Stakeholder Couldn't Log-in", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(SignIn.this, "Try Again", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }else {
                    Toast.makeText(SignIn.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignIn.this, "Try Again", Toast.LENGTH_SHORT).show();
                }



        }

    }
}
