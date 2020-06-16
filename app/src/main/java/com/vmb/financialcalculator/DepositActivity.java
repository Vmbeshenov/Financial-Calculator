package com.vmb.financialcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class DepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        EditText initialSumText = (EditText) findViewById(R.id.textInitialSum);
        initialSumText.addTextChangedListener(new NumberTextWatcher(initialSumText));
        initialSumText.setText(R.string.deposit_initial_sum);

        EditText interestRateSumText = (EditText) findViewById(R.id.textInterestRate);
        interestRateSumText.setText(R.string.deposit_interest_rate);

        EditText yearText = (EditText) findViewById(R.id.textYear);
        yearText.setText(R.string.deposit_year);

        EditText monthText = (EditText) findViewById(R.id.textMonth);
        monthText.setText(R.string.deposit_month);

        EditText additionalSumText = (EditText) findViewById(R.id.textAdditionalSum);
        additionalSumText.addTextChangedListener(new NumberTextWatcher(additionalSumText));
        additionalSumText.setText(R.string.deposit_additional_sum);
    }

    public void onClickCalculateDeposit(View view){

        Deposit deposit = new Deposit();
        String enter_data;

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textInitialSum)).getText().toString());
        deposit.setInitial_sum(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textInterestRate)).getText().toString());
        deposit.setInterest_rate(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textYear)).getText().toString());
        deposit.setYear(Integer.parseInt(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textMonth)).getText().toString());
        deposit.setMonth(Integer.parseInt(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textAdditionalSum)).getText().toString());
        deposit.setAdditional_sum(Double.parseDouble(enter_data));

        CheckBox checkBoxCapitalization = (CheckBox) findViewById(R.id.checkBoxCapitalization);
        boolean capitalization = checkBoxCapitalization.isChecked();

        deposit.CalculateDeposit(capitalization);

        Intent intent = new Intent(this, DepositResultActivity.class);
        intent.putExtra(Deposit.class.getSimpleName(), deposit);
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