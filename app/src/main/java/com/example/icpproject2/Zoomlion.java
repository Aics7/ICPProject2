package com.example.icpproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Zoomlion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomlion);

        if(MakePayment.akornoBinNum>=5){
            TextView newTextView=(TextView) findViewById(R.id.akonum);
            newTextView.setText("Full");
        }
        else{
            TextView newTextView=(TextView) findViewById(R.id.akonum);
            newTextView.setText(""+MakePayment.akornoBinNum);
        }
        if(MakePayment.BigBenBinNum>=5){
            TextView newTextView=(TextView) findViewById(R.id.bignum);
            newTextView.setText("Full");
        }
        else{
            TextView newTextView1=(TextView) findViewById(R.id.bignum);
            newTextView1.setText(""+MakePayment.BigBenBinNum);
        }

        if(MakePayment.EssentialsBinNum>=5){
            TextView newTextView=(TextView) findViewById(R.id.essnum);
            newTextView.setText("Full");
        }
        else{
            TextView newTextView2=(TextView) findViewById(R.id.essnum);
            newTextView2.setText(""+MakePayment.EssentialsBinNum);
        }
    }
}
