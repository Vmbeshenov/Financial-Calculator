package com.vmb.financialcalculator;

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
    }

    public void onClickCalculateCredit(View view){

        Credit credit = new Credit();
        String enter_data;

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textFirstSumCredit)).getText().toString());
        credit.setFirst_sum(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textInterestRateCredit)).getText().toString());
        credit.setInterest_rate(Double.parseDouble(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textYearCredit)).getText().toString());
        credit.setYear(Integer.parseInt(enter_data));

        enter_data = CorrectEnterData(((EditText)findViewById(R.id.textMonthCredit)).getText().toString());
        credit.setMonth(Integer.parseInt(enter_data));

        ToggleButton toggleButtonPaymentType = (ToggleButton) findViewById(R.id.CreditTypePayment);
        boolean payment_type_annuity = toggleButtonPaymentType.isChecked();

        credit.CalculateCredit(payment_type_annuity);

        EditText total = (EditText) findViewById(R.id.textTotalCredit);
        total.setText(String.valueOf((long)credit.getTotal()));

        EditText interest_charge = (EditText) findViewById(R.id.textInterestChargeCredit);
        interest_charge.setText(String.valueOf((long)credit.getInterest_charge()));

        EditText monthly_installment = (EditText) findViewById(R.id.textMonthlyInstallmentCredit);
        monthly_installment.setText(String.valueOf((long)credit.getMonthly_installment()));
    }

    private String CorrectEnterData(String data){
        if (data.equals("")){
            data = "0";
        }
        return data;
    }
}