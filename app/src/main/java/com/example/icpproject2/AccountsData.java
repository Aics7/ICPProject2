package com.example.icpproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AccountsData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_data);

        String data = "";
        int index = 0;
        DecimalFormat format = new DecimalFormat("#####0.00");
        for (String i : MakePayment.accountnames) {
            data = data + "Account name: " + i + "\nAccount balance: GHc " + format.format(MakePayment.balance.get(index)) + "\n\n";
            index++;
        }
        TextView newTextView=(TextView) findViewById(R.id.balances);
        newTextView.setText(data);
    }
}
