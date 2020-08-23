package com.vmb.financialcalculator

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
        val interest_charge = findViewById<TextView>(R.id.textInterestChargeCredit)
        interest_charge.text = String.format("%,d", credit.interest_charge.toLong())
        val monthly_installment = findViewById<TextView>(R.id.textMonthlyInstallmentCredit)
        monthly_installment.text = String.format("%,d", credit.monthly_installment.toLong())
    }
}