package com.example.icpproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{


    TextView usersName;
    static String userName;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersName = (TextView) findViewById(R.id.textView7);
        userName=usersName.getText().toString();
        if(MakePayment.accountnames.size()>0){
            usersName.setText(MakePayment.accountnames.get(MakePayment.accountnames.size()-1));
        }


        Button btn = (Button) findViewById(R.id.btnShow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_example, popup.getMenu());
                popup.show();
            }
        });
    }

    public void scan(View view){
        Intent int1=new Intent(MainActivity.this,Scanner.class);
        startActivity(int1);
    }
    public void getGuardian(View view){
        Intent int1=new Intent(MainActivity.this,LeaderBoad.class);
        startActivity(int1);
    }
    public void createAccount(View view){
        Intent int1=new Intent(MainActivity.this,CreateAccount.class);
        startActivity(int1);
    }

//    public void getAllAccountData(View view){
//        Intent int1=new Intent(MainActivity.this,AccountsData.class);
//        startActivity(int1);
//    }

    public void logOut(View view){
        Intent int1=new Intent(MainActivity.this,CreateAccount.class);
        startActivity(int1);
    }
    public void myAccount(View view){
        Intent int1=new Intent(MainActivity.this,MyAccount.class);
        startActivity(int1);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
                case R.id.essentials:
                Toast.makeText(this, "Selected Stakeholder: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent int2 = new Intent(MainActivity.this, Essentials.class);
                startActivity(int2);
                return true;
            case R.id.bigben:
                Toast.makeText(this, "Selected Stakeholder: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent int3 = new Intent(MainActivity.this, Bigben.class);
                startActivity(int3);
                return true;
            case R.id.akorno:
                Toast.makeText(this, "Selected Stakeholder: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent int4 = new Intent(MainActivity.this, Akorno.class);
                startActivity(int4);

                return true;
            case R.id.outAshesi:
                Toast.makeText(this, "Selected Stakeholder: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent int5 = new Intent(MainActivity.this, OutsideAshesi.class);
                startActivity(int5);

                return true;
            default:
                return false;
        }
    }



}
