package com.vmbeshenov.financialcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class CreditResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_result)

        val arguments = intent.extras
        val credit = arguments!!.getSerializable(Credit::class.java.simpleName) as Credit?

        val total = findViewById<TextView>(R.id.textTotalCredit)
        total.text = String.format("%,d", credit!!.total.toLong())

        val interestCharge = findViewById<TextView>(R.id.textInterestChargeCredit)
        interestCharge.text = String.format("%,d", credit.interestCharge.toLong())

        val monthlyInstallment = findViewById<TextView>(R.id.textMonthlyInstallmentCredit)
        monthlyInstallment.text = String.format("%,d", credit.monthlyInstallment.toLong())
    }
}