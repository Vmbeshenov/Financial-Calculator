package com.vmb.financialcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class CreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        EditText initialSumText = (EditText) findViewById(R.id.textInitialSumCredit);
        initialSumText.addTextChangedListener(new NumberTextWatcher(initialSumText));
        initialSumText.setText(R.string.credit_initial_sum);

        EditText interestRateSumText = (EditText) findViewById(R.id.textInterestRateCredit);
        interestRateSumText.setText(R.string.credit_interest_rate);

        EditText yearText = (EditText) findViewById(R.id.textYearCredit);
        yearText.setText(R.string.credit_year);

        EditText monthText = (EditText) findViewById(R.id.textMonthCredit);
        monthText.setText(R.string.credit_month);
    }

    public void onClickCalculateCredit(View view){

        Credit credit = new Credit();
        String enter_data;

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textInitialSumCredit)).getText().toString());
        credit.setInitial_sum(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textInterestRateCredit)).getText().toString());
        credit.setInterest_rate(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textYearCredit)).getText().toString());
        credit.setYear(Integer.parseInt(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textMonthCredit)).getText().toString());
        credit.setMonth(Integer.parseInt(enter_data));

        ToggleButton toggleButtonPaymentType = (ToggleButton) findViewById(R.id.CreditTypePayment);
        boolean payment_type_annuity = toggleButtonPaymentType.isChecked();

        credit.CalculateCredit(payment_type_annuity);

        Intent intent = new Intent(this, CreditResultActivity.class);
        intent.putExtra(Credit.class.getSimpleName(), credit);
        startActivity(intent);
    }

    private String CorrectEnterData(String data){
        if (data.equals("")){
            data = "0";
        }
        data = data.replaceAll("\\s+","");
        return data;
    }
}