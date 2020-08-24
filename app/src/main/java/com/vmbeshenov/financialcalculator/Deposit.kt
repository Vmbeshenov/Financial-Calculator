package com.vmbeshenov.financialcalculator

import java.io.Serializable

class Deposit : Serializable {

    private var initialSum = 0.0
    private var interestRate = 0.0
    private var year = 0
    private var month = 0
    private var additionalPayment = 0.0
    var total = 0.0
        private set
    var profit = 0.0
        private set
    var amountOfAdditionalPayments = 0.0
        private set

    fun calculateDeposit(capitalization: Boolean) {

        if (capitalization) {
            total = initialSum
            for (j in 0 until year * 12 + month) {
                total += total * interestRate / 100 / 12 + additionalPayment
                amountOfAdditionalPayments += additionalPayment
            }
        } else {
            total = initialSum
            for (i in 0 until year) {
                total += total * interestRate / 100 + additionalPayment
                amountOfAdditionalPayments += additionalPayment
            }
            total += total * interestRate / 100 / 12 * month
        }

        profit = total - initialSum - amountOfAdditionalPayments
    }

    fun setInitialSum(initial_sum: String) {
        this.initialSum = initial_sum.toDouble()
    }

    fun setInterestRate(interest_rate: String) {
        this.interestRate = interest_rate.toDouble()
    }

    fun setYear(year: String) {
        this.year = year.toInt()
    }

    fun setMonth(month: String) {
        this.month = month.toInt()
    }

    fun setAdditionalPayment(additionalPayment: String) {
        this.additionalPayment = additionalPayment.toDouble()
    }
}