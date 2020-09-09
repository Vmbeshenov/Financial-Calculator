package com.vmbeshenov.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.vmbeshenov.financialcalculator.NumberTextWatcher.Companion.getStringInView

class DepositActivity : AppCompatActivity() {

    private val deposit = Deposit()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        val initialSumText = findViewById<EditText>(R.id.textInitialSum)
        initialSumText.addTextChangedListener(NumberTextWatcher(initialSumText))
        initialSumText.setText(deposit.initialSum.toLong().toString())

        val interestRateSumText = findViewById<EditText>(R.id.textInterestRate)
        interestRateSumText.setText(deposit.interestRate.toString())

        val yearText = findViewById<EditText>(R.id.textYear)
        yearText.setText(deposit.year.toString())

        val monthText = findViewById<EditText>(R.id.textMonth)
        monthText.setText(deposit.month.toString())

        val additionalSumText = findViewById<EditText>(R.id.textAdditionalPayment)
        additionalSumText.addTextChangedListener(NumberTextWatcher(additionalSumText))
        additionalSumText.setText(deposit.additionalPayment.toLong().toString())
    }

    fun onClickCalculateDeposit(view: View?) {

        deposit.initialSum = getStringInView(findViewById(R.id.textInitialSum)).toDouble()
        deposit.interestRate = getStringInView(findViewById(R.id.textInterestRate)).toDouble()
        deposit.year = getStringInView(findViewById(R.id.textYear)).toInt()
        deposit.month = getStringInView(findViewById(R.id.textMonth)).toInt()
        deposit.additionalPayment = getStringInView(findViewById(R.id.textAdditionalPayment)).toDouble()

        deposit.capitalization = (findViewById<View>(R.id.checkBoxCapitalization) as CheckBox).isChecked
        deposit.calculateDeposit()

        val intent = Intent(this, DepositResultActivity::class.java)
        intent.putExtra(Deposit::class.java.simpleName, deposit)
        startActivity(intent)
    }
}