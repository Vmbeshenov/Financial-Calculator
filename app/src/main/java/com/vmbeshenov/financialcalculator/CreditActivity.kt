package com.vmbeshenov.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import com.vmbeshenov.financialcalculator.NumberTextWatcher.Companion.getStringInView

class CreditActivity : AppCompatActivity() {

    private val credit = Credit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val initialSumText = findViewById<EditText>(R.id.textInitialSumCredit)
        initialSumText.addTextChangedListener(NumberTextWatcher(initialSumText))
        initialSumText.setText(credit.initialSum.toLong().toString())

        val interestRateSumText = findViewById<EditText>(R.id.textInterestRateCredit)
        interestRateSumText.setText(credit.interestRate.toString())

        val yearText = findViewById<EditText>(R.id.textYearCredit)
        yearText.setText(credit.year.toString())

        val monthText = findViewById<EditText>(R.id.textMonthCredit)
        monthText.setText(credit.month.toString())
    }

    fun onClickCalculateCredit(view: View?) {
        credit.initialSum = getStringInView(findViewById(R.id.textInitialSumCredit)).toDouble()
        credit.interestRate = getStringInView(findViewById(R.id.textInterestRateCredit)).toDouble()
        credit.year = getStringInView(findViewById(R.id.textYearCredit)).toInt()
        credit.month = getStringInView(findViewById(R.id.textMonthCredit)).toInt()

        credit.calculateCredit()

        val intent = Intent(this, CreditResultActivity::class.java)
        intent.putExtra(Credit::class.java.simpleName, credit)
        startActivity(intent)
    }
}