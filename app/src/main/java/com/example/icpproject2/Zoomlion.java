package com.example.icpproject2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Zoomlion extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomlion);

        if (MakePayment.akornoBinNum >= 5) {
            TextView newTextView = (TextView) findViewById(R.id.akonum);
            newTextView.setText("Full");
            sendEmail("Akorno");
        } else {
            TextView newTextView = (TextView) findViewById(R.id.akonum);
            newTextView.setText("" + MakePayment.akornoBinNum);
        }
        if (MakePayment.BigBenBinNum >= 5) {
            TextView newTextView = (TextView) findViewById(R.id.bignum);
            newTextView.setText("Full");
            sendEmail("BigBen");
        } else {
            TextView newTextView1 = (TextView) findViewById(R.id.bignum);
            newTextView1.setText("" + MakePayment.BigBenBinNum);
        }

        if (MakePayment.EssentialsBinNum >= 5) {
            TextView newTextView = (TextView) findViewById(R.id.essnum);
            newTextView.setText("Full");
            sendEmail("Essentials");
        } else {
            TextView newTextView2 = (TextView) findViewById(R.id.essnum);
            newTextView2.setText("" + MakePayment.EssentialsBinNum);
        }
    }

    public void sendEmail(String location) {
        Log.i("Send email", "");

        String[] TO = {"issifu.alhassan@ashesi.edu.gh"};
        String[] CC = {"faweenagua@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bin at "+location+" is full");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Manager, \n the bin placed at "+location+" is filled to its capacity. " +
                "Five bottles have been placed there hence you should be ready to pay GHc 1.00 upon collection\n\n Best regards\n Repsyche.");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Mail sent...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Zoomlion.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
