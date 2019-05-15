package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float percentage = 0;
    float tipTotal = 0;
    float finalBillAmount = 0;

    float regularPercentage = 10;
    float goodPercentege = 15;
    float excellentPercentege = 20;

    float totalBillAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton ibRegular = (ImageButton) findViewById(R.id.ibregular);
        ImageButton ibgood = (ImageButton) findViewById(R.id.ibgood);
        ImageButton ibExcellent = (ImageButton) findViewById(R.id.ibexcellent);

        ibRegular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage=regularPercentage;
                billCalculation();
                setTipValues();
            }
        });

//        ibRegular.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                percentage = regularPercentage;
//                billCalculation();
//                setTipValues();
//            }
//
//        });

        ibgood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = goodPercentege;
                billCalculation();
                setTipValues();
            }
        });

        ibExcellent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = excellentPercentege;
                billCalculation();
                setTipValues();
            }
        });


        billCalculation();
        setTipValues();
        EditText etBill = (EditText) findViewById(R.id.etbillamount);

        etBill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                billCalculation();
                setTipValues();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    private void billCalculation() {
        EditText etBill = (EditText) findViewById(R.id.etbillamount);

        if (percentage == 0)
            percentage = goodPercentege;
        if (!etBill.getText().toString().equals("") && !etBill.getText().toString().equals("."))
            totalBillAmount = Float.valueOf(etBill.getText().toString());
        else
            totalBillAmount = 0;

        tipTotal = totalBillAmount * percentage / 100;
        finalBillAmount = totalBillAmount + tipTotal;
    }

    private void setTipValues() {
        TextView tvTipPerrcent = (TextView) findViewById(R.id.tvtippercent);
        TextView tvTipAmount = (TextView) findViewById(R.id.tvtiptotal);
        TextView tvFinalBillAmount = (TextView) findViewById(R.id.tvfinalbillamount);

        tvTipPerrcent.setText("" + percentage + "% Tip Percent");
        tvTipAmount.setText("$" + tipTotal + " Tip Total");
        tvFinalBillAmount.setText("$" + finalBillAmount);
    }


}
