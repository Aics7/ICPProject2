package com.example.icpproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view){
        Intent int1=new Intent(MainActivity.this,Scanner.class);
        startActivity(int1);
    }
    public void createAccount(View view){
        Intent int1=new Intent(MainActivity.this,CreateAccount.class);
        startActivity(int1);
    }

    public void getAllAccountData(View view){
        Intent int1=new Intent(MainActivity.this,AccountsData.class);
        startActivity(int1);
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
