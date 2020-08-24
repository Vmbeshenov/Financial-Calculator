package com.vmbeshenov.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ToggleButton
import com.vmbeshenov.financialcalculator.NumberTextWatcher.Companion.getStringInView

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
        credit.setInitialSum(getStringInView(findViewById<View>(R.id.textInitialSumCredit)))
        credit.setInterestRate(getStringInView(findViewById<View>(R.id.textInterestRateCredit)))
        credit.setYear(getStringInView(findViewById<View>(R.id.textYearCredit)))
        credit.setMonth(getStringInView(findViewById<View>(R.id.textMonthCredit)))

        val annuityPaymentType = (findViewById<View>(R.id.TypePaymentCredit) as ToggleButton).isChecked
        credit.calculateCredit(annuityPaymentType)

        val intent = Intent(this, CreditResultActivity::class.java)
        intent.putExtra(Credit::class.java.simpleName, credit)
        startActivity(intent)
    }
}