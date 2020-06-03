package com.vmb.financialcalculator;

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
    }

    public void onClickCalculateDeposit(View view){

        Deposit deposit = new Deposit();
        String enter_data;

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textFirstSum)).getText().toString());
        deposit.setFirst_sum(Double.parseDouble(enter_data));

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

        EditText total = (EditText) findViewById(R.id.textTotal);
        total.setText(String.valueOf((long)deposit.getTotal()));

        EditText profit = (EditText) findViewById(R.id.textProfit);
        profit.setText(String.valueOf((long)deposit.getProfit()));

        EditText additional_sum_total = (EditText) findViewById(R.id.textAdditionalSumTotal);
        additional_sum_total.setText(String.valueOf((long)deposit.getAdditional_sum_total()));
    }

    private String CorrectEnterData(String data){
        if (data.equals("")){
            data = "0";
        }
        return data;
    }
}