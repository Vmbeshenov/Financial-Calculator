package com.vmb.financialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
    }

    public void onClickCalculateDeposit(View view){

        Deposit deposit = new Deposit();
        deposit.setFirst_sum(Double.parseDouble(((EditText)findViewById(R.id.textFirstSum)).getText().toString()));
        deposit.setInterest_rate(Double.parseDouble(((EditText)findViewById(R.id.textInterestRate)).getText().toString()));
        deposit.setYear(Integer.parseInt(((EditText)findViewById(R.id.textYear)).getText().toString()));
        deposit.setMonth(Integer.parseInt(((EditText)findViewById(R.id.textMonth)).getText().toString()));
        deposit.setAdditional_sum(Double.parseDouble(((EditText)findViewById(R.id.textAdditionalSum)).getText().toString()));

        deposit.CalculateDeposit();

        EditText total = (EditText) findViewById(R.id.textTotal);
        total.setText(String.valueOf(deposit.getTotal()));

        EditText profit = (EditText) findViewById(R.id.textProfit);
        profit.setText(String.valueOf(deposit.getProfit()));

        EditText additional_sum_total = (EditText) findViewById(R.id.textAdditionalSumTotal);
        additional_sum_total.setText(String.valueOf(deposit.getAdditional_sum_total()));
    }
}