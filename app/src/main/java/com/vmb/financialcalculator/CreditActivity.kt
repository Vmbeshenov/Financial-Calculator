package com.vmb.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ToggleButton
import com.vmb.financialcalculator.NumberTextWatcher.Companion.GetStringInView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)
        val initialSumText = findViewById<EditText>(R.id.textInitialSumCredit)
        initialSumText.addTextChangedListener(NumberTextWatcher(initialSumText))
        initialSumText.setText(R.string.credit_initial_sum)
        val interestRateSumText = findViewById<EditText>(R.id.textInterestRateCredit)
        interestRateSumText.setText(R.string.credit_interest_rate)
        val yearText = findViewById<EditText>(R.id.textYearCredit)
        yearText.setText(R.string.credit_year)
        val monthText = findViewById<EditText>(R.id.textMonthCredit)
        monthText.setText(R.string.credit_month)
    }

    fun onClickCalculateCredit(view: View?) {
        val credit = Credit()
        credit.setInitial_sum(GetStringInView(findViewById<View>(R.id.textInitialSumCredit)))
        credit.setInterest_rate(GetStringInView(findViewById<View>(R.id.textInterestRateCredit)))
        credit.setYear(GetStringInView(findViewById<View>(R.id.textYearCredit)))
        credit.setMonth(GetStringInView(findViewById<View>(R.id.textMonthCredit)))
        val payment_type_is_annuity = (findViewById<View>(R.id.CreditTypePayment) as ToggleButton).isChecked
        credit.CalculateCredit(payment_type_is_annuity)
        val intent = Intent(this, CreditResultActivity::class.java)
        intent.putExtra(Credit::class.java.simpleName, credit)
        startActivity(intent)
    }
}