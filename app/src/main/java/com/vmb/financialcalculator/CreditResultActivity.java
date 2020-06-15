package com.vmb.financialcalculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CreditResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle arguments = getIntent().getExtras();
        Credit credit = (Credit) arguments.getSerializable(Credit.class.getSimpleName());

        EditText total = (EditText) findViewById(R.id.textTotalCredit);
        total.setText(String.valueOf((long)credit.getTotal()));

        EditText interest_charge = (EditText) findViewById(R.id.textInterestChargeCredit);
        interest_charge.setText(String.valueOf((long)credit.getInterest_charge()));

        EditText monthly_installment = (EditText) findViewById(R.id.textMonthlyInstallmentCredit);
        monthly_installment.setText(String.valueOf((long)credit.getMonthly_installment()));
    }
}