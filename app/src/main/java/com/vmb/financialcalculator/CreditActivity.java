package com.vmb.financialcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import static com.vmb.financialcalculator.NumberTextWatcher.GetStringInView;

public class CreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        EditText initialSumText = findViewById(R.id.textInitialSumCredit);
        initialSumText.addTextChangedListener(new NumberTextWatcher(initialSumText));
        initialSumText.setText(R.string.credit_initial_sum);

        EditText interestRateSumText = findViewById(R.id.textInterestRateCredit);
        interestRateSumText.setText(R.string.credit_interest_rate);

        EditText yearText = findViewById(R.id.textYearCredit);
        yearText.setText(R.string.credit_year);

        EditText monthText = findViewById(R.id.textMonthCredit);
        monthText.setText(R.string.credit_month);
    }

    public void onClickCalculateCredit(View view){

        Credit credit = new Credit();
        credit.setInitial_sum(GetStringInView(findViewById(R.id.textInitialSumCredit)));
        credit.setInterest_rate(GetStringInView(findViewById(R.id.textInterestRateCredit)));
        credit.setYear(GetStringInView(findViewById(R.id.textYearCredit)));
        credit.setMonth(GetStringInView(findViewById(R.id.textMonthCredit)));
        boolean payment_type_is_annuity = ((ToggleButton) findViewById(R.id.CreditTypePayment)).isChecked();

        credit.CalculateCredit(payment_type_is_annuity);

        Intent intent = new Intent(this, CreditResultActivity.class);
        intent.putExtra(Credit.class.getSimpleName(), credit);
        startActivity(intent);
    }
}