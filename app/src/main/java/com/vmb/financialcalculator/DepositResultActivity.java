package com.vmb.financialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DepositResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_result);

        Bundle arguments = getIntent().getExtras();
        Deposit deposit = (Deposit) arguments.getSerializable(Deposit.class.getSimpleName());

        TextView total = findViewById(R.id.textTotal);
        total.setText(String.format("%,d", (long)deposit.getTotal()));

        TextView profit = findViewById(R.id.textProfit);
        profit.setText(String.format("%,d", (long)deposit.getProfit()));

        TextView additional_sum_total = findViewById(R.id.textAdditionalSumTotal);
        additional_sum_total.setText(String.format("%,d", (long)deposit.getAdditional_sum_total()));
    }
}