package com.example.icpproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Akorno extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akorno);
        Spinner createdAccounts = (Spinner) findViewById(R.id.spinner7);
        createdAccounts.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,MakePayment.accounts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        createdAccounts.setAdapter(aa);

    }

    public void purchaseA(View view){
        String item = ((EditText) findViewById(R.id.editText19)).getText().toString();
        int number = Integer.parseInt(((EditText) findViewById(R.id.editText20)).getText().toString());
        double price = Double.parseDouble(((EditText) findViewById(R.id.editText21)).getText().toString());
        Spinner account=(Spinner) findViewById(R.id.spinner7);
        String selectedAccount=String.valueOf(account.getSelectedItem());
        String password = ((EditText) findViewById(R.id.editText22)).getText().toString();
        double amount=number*price;

        if(item.length()>0 && number>0&&price>0&&selectedAccount.length()>0){
            int index=MakePayment.accountnames.indexOf(selectedAccount);
            if(password.equals(MakePayment.password.get(index))){
                double newBalance=0;
                if(MakePayment.balance.get(index)>amount){
                    newBalance=MakePayment.balance.get(index);
                    MakePayment.balance.set(index,newBalance);
                    Toast.makeText(getApplicationContext(), "Purchase successful", Toast.LENGTH_LONG).show();
                    String message=selectedAccount+" has purchase "+ number + " "+item+"(s)"+ " for GHc "+amount;
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not enough balance", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Purchase unsuccessful", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
