package com.vmb.financialcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DepositResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit_result)
        val arguments = intent.extras
        val deposit = arguments!!.getSerializable(Deposit::class.java.simpleName) as Deposit?
        val total = findViewById<TextView>(R.id.textTotal)
        total.text = String.format("%,d", deposit!!.total.toLong())
        val profit = findViewById<TextView>(R.id.textProfit)
        profit.text = String.format("%,d", deposit.profit.toLong())
        val additional_sum_total = findViewById<TextView>(R.id.textAdditionalSumTotal)
        additional_sum_total.text = String.format("%,d", deposit.additional_sum_total.toLong())
    }
}