package com.vmb.financialcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickStartDeposit(view: View?) {
        val intent = Intent(this, DepositActivity::class.java)
        startActivity(intent)
    }

    fun onClickStartCredit(view: View?) {
        val intent = Intent(this, CreditActivity::class.java)
        startActivity(intent)
    }
}