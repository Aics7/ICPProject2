package com.example.icpproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

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
    public void showStakeholders(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_example, popup.getMenu());
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.zoomlion:
                Intent int1=new Intent(MainActivity.this,Zoomlion.class);
                startActivity(int1);
            case R.id.essentials:
                Intent int2=new Intent(MainActivity.this,Essentials.class);
                startActivity(int2);
            case R.id.bigben:
                Intent int3=new Intent(MainActivity.this,Bigben.class);
                startActivity(int3);
            case R.id.akorno:
                Intent int4=new Intent(MainActivity.this,Akorno.class);
                startActivity(int4);
        }
        return true;
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
