package com.example.icpproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Essentials extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essentials);
        Spinner createdAccounts = (Spinner) findViewById(R.id.spinner);
        createdAccounts.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,MakePayment.accounts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        createdAccounts.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
