package com.vmbeshenov.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.vmbeshenov.financialcalculator.NumberTextWatcher.Companion.getStringInView

class DepositActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        val initialSumText = findViewById<EditText>(R.id.textInitialSum)
        initialSumText.addTextChangedListener(NumberTextWatcher(initialSumText))
        initialSumText.setText(R.string.deposit_initial_sum)

        val interestRateSumText = findViewById<EditText>(R.id.textInterestRate)
        interestRateSumText.setText(R.string.deposit_interest_rate)

        val yearText = findViewById<EditText>(R.id.textYear)
        yearText.setText(R.string.deposit_year)

        val monthText = findViewById<EditText>(R.id.textMonth)
        monthText.setText(R.string.deposit_month)

        val additionalSumText = findViewById<EditText>(R.id.textAdditionalPayment)
        additionalSumText.addTextChangedListener(NumberTextWatcher(additionalSumText))
        additionalSumText.setText(R.string.deposit_additional_sum)
    }

    fun onClickCalculateDeposit(view: View?) {
        val deposit = Deposit()
        deposit.setInitialSum(getStringInView(findViewById<View>(R.id.textInitialSum)))
        deposit.setInterestRate(getStringInView(findViewById<View>(R.id.textInterestRate)))
        deposit.setYear(getStringInView(findViewById<View>(R.id.textYear)))
        deposit.setMonth(getStringInView(findViewById<View>(R.id.textMonth)))
        deposit.setAdditionalPayment(getStringInView(findViewById<View>(R.id.textAdditionalPayment)))

        val capitalization = (findViewById<View>(R.id.checkBoxCapitalization) as CheckBox).isChecked
        deposit.calculateDeposit(capitalization)

        val intent = Intent(this, DepositResultActivity::class.java)
        intent.putExtra(Deposit::class.java.simpleName, deposit)
        startActivity(intent)
    }
}