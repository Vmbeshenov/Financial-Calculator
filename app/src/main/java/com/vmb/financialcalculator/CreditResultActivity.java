package com.vmb.financialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CreditResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_result);

        Bundle arguments = getIntent().getExtras();
        Credit credit = (Credit) arguments.getSerializable(Credit.class.getSimpleName());

        TextView total = findViewById(R.id.textTotalCredit);
        total.setText(String.format("%,d", (long)credit.getTotal()));

        TextView interest_charge = findViewById(R.id.textInterestChargeCredit);
        interest_charge.setText(String.format("%,d", (long)credit.getInterest_charge()));

        TextView monthly_installment = findViewById(R.id.textMonthlyInstallmentCredit);
        monthly_installment.setText(String.format("%,d", (long)credit.getMonthly_installment()));
    }
}