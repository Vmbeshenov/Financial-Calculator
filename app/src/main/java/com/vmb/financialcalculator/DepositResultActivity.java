package com.vmb.financialcalculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DepositResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle arguments = getIntent().getExtras();
        Deposit deposit = (Deposit) arguments.getSerializable(Deposit.class.getSimpleName());

        EditText total = (EditText) findViewById(R.id.textTotal);
        total.addTextChangedListener(new NumberTextWatcher(total));
        total.setText(String.valueOf((long)deposit.getTotal()));

        EditText profit = (EditText) findViewById(R.id.textProfit);
        profit.addTextChangedListener(new NumberTextWatcher(profit));
        profit.setText(String.valueOf((long)deposit.getProfit()));

        EditText additional_sum_total = (EditText) findViewById(R.id.textAdditionalSumTotal);
        additional_sum_total.addTextChangedListener(new NumberTextWatcher(additional_sum_total));
        additional_sum_total.setText(String.valueOf((long)deposit.getAdditional_sum_total()));
    }
}