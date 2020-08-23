package com.vmb.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.vmb.financialcalculator.NumberTextWatcher.Companion.GetStringInView

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
        val additionalSumText = findViewById<EditText>(R.id.textAdditionalSum)
        additionalSumText.addTextChangedListener(NumberTextWatcher(additionalSumText))
        additionalSumText.setText(R.string.deposit_additional_sum)
    }

    fun onClickCalculateDeposit(view: View?) {
        val deposit = Deposit()
        deposit.setInitial_sum(GetStringInView(findViewById<View>(R.id.textInitialSum)))
        deposit.setInterest_rate(GetStringInView(findViewById<View>(R.id.textInterestRate)))
        deposit.setYear(GetStringInView(findViewById<View>(R.id.textYear)))
        deposit.setMonth(GetStringInView(findViewById<View>(R.id.textMonth)))
        deposit.setAdditional_sum(GetStringInView(findViewById<View>(R.id.textAdditionalSum)))
        val capitalization = (findViewById<View>(R.id.checkBoxCapitalization) as CheckBox).isChecked
        deposit.CalculateDeposit(capitalization)
        val intent = Intent(this, DepositResultActivity::class.java)
        intent.putExtra(Deposit::class.java.simpleName, deposit)
        startActivity(intent)
    }
}