package com.example.icpproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MakePayment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static ArrayList<String> accounts =new ArrayList<String>();
    public static ArrayList<String> accountnames =new ArrayList<String>();
    public static ArrayList<Double> balance =new ArrayList<Double>();
    public static ArrayList<String> password =new ArrayList<String>();
    public static ArrayList<Integer> bottlesScanned =new ArrayList<Integer>();
    public static int akornoBinNum=0;
    public static int BigBenBinNum=0;
    public static int EssentialsBinNum=0;
    public static String [] bins={"Akorno","Bigben","Essentials"};

    boolean paid=false;

    private Zoomlion zoom=new Zoomlion();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);

        Spinner createdAccounts = (Spinner) findViewById(R.id.acc);
        createdAccounts.setOnItemSelectedListener(this);

        Spinner binPlaces = (Spinner) findViewById(R.id.binplace);
        createdAccounts.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,accountnames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        createdAccounts.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bins);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binPlaces.setAdapter(aa1);
        paid=false;
    }

    public void pay (View view){
        Spinner createdAccounts=(Spinner) findViewById(R.id.acc);
        Spinner bins=(Spinner) findViewById(R.id.binplace);
        String selected=String.valueOf(createdAccounts.getSelectedItem());
        String selectedBin=String.valueOf(bins.getSelectedItem());
        if (!(Scanner.alreadyScanned)&&!paid){
            int indexToPay=accountnames.indexOf(selected);
            double newBalance=balance.get(indexToPay)+0.20;
            balance.set(indexToPay,newBalance);
            int newnum=bottlesScanned.get(indexToPay)+1;
            bottlesScanned.set(indexToPay,newnum);
            String print="GHc 0.20 credited to account: "+selected;
            Toast.makeText(getApplicationContext(), print, Toast.LENGTH_LONG).show();
            paid=true;
            Scanner.barCodes.add(Scanner.tempBarcodes.pop());

            if (selectedBin.equalsIgnoreCase("Akorno")&&akornoBinNum>=5){
                Toast.makeText(getApplicationContext(), "bin full, contact Zoomlion for pickup", Toast.LENGTH_LONG).show();
                akornoBinNum++;
                zoom.sendEmail(selectedBin);
            }
            else if (selectedBin.equalsIgnoreCase("Akorno")&&akornoBinNum<5){
                akornoBinNum++;
            }

            if (selectedBin.equalsIgnoreCase("BigBen")&&BigBenBinNum>=5){
                Toast.makeText(getApplicationContext(), "bin full, contact Zoomlion for pickup", Toast.LENGTH_LONG).show();
                akornoBinNum++;
                zoom.sendEmail(selectedBin);
            }
            else if (selectedBin.equalsIgnoreCase("BigBen")){
                BigBenBinNum++;
            }

            if (selectedBin.equalsIgnoreCase("Essentials")&&EssentialsBinNum>=5){
                Toast.makeText(getApplicationContext(), "bin full, contact Zoomlion for pickup", Toast.LENGTH_LONG).show();
                akornoBinNum++;
                zoom.sendEmail(selectedBin);
            }
            else if (selectedBin.equalsIgnoreCase("Essentials")){
                EssentialsBinNum++;
            }

        }
        else{
            Toast.makeText(getApplicationContext(), "Payment cannot be made; Product has already been scanned by another user", Toast.LENGTH_LONG).show();
        }

    }

    public void createAccount (View view){
        Intent int1=new Intent(MakePayment.this,CreateAccount.class);
        startActivity(int1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
