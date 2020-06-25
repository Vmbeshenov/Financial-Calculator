package com.vmb.financialcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import static com.vmb.financialcalculator.NumberTextWatcher.GetStringInView;

public class DepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        EditText initialSumText = findViewById(R.id.textInitialSum);
        initialSumText.addTextChangedListener(new NumberTextWatcher(initialSumText));
        initialSumText.setText(R.string.deposit_initial_sum);

        EditText interestRateSumText = findViewById(R.id.textInterestRate);
        interestRateSumText.setText(R.string.deposit_interest_rate);

        EditText yearText = findViewById(R.id.textYear);
        yearText.setText(R.string.deposit_year);

        EditText monthText = findViewById(R.id.textMonth);
        monthText.setText(R.string.deposit_month);

        EditText additionalSumText =findViewById(R.id.textAdditionalSum);
        additionalSumText.addTextChangedListener(new NumberTextWatcher(additionalSumText));
        additionalSumText.setText(R.string.deposit_additional_sum);
    }

    public void onClickCalculateDeposit(View view) {

        Deposit deposit = new Deposit();
        deposit.setInitial_sum(GetStringInView(findViewById(R.id.textInitialSum)));
        deposit.setInterest_rate(GetStringInView(findViewById(R.id.textInterestRate)));
        deposit.setYear(GetStringInView(findViewById(R.id.textYear)));
        deposit.setMonth(GetStringInView(findViewById(R.id.textMonth)));
        deposit.setAdditional_sum(GetStringInView(findViewById(R.id.textAdditionalSum)));
        boolean capitalization = ((CheckBox) findViewById(R.id.checkBoxCapitalization)).isChecked();

        deposit.CalculateDeposit(capitalization);

        Intent intent = new Intent(this, DepositResultActivity.class);
        intent.putExtra(Deposit.class.getSimpleName(), deposit);
        startActivity(intent);
    }
}