package com.vmbeshenov.financialcalculator

import java.io.Serializable

class Credit : Serializable {
    private var initialSum = 0.0
    private var interestRate = 0.0
    private var year = 0
    private var month = 0
    var total = 0.0
        private set
    var interestCharge = 0.0
        private set
    var monthlyInstallment = 0.0
        private set

    fun calculateCredit(annuityPaymentType: Boolean) {
        if (annuityPaymentType) {
            val interestRateForOneMonth = 1 + interestRate / 100 / 12
            var finalInterestRate = interestRateForOneMonth
            for (i in 0 until year * 12 + month - 1) {
                finalInterestRate *= interestRateForOneMonth
            }
            monthlyInstallment = initialSum * (interestRate / 100 / 12 + interestRate / 100 / 12 / (finalInterestRate - 1))
            total = monthlyInstallment * (year * 12 + month)
        } else {
            val arrayOfMonthlyInstallment = DoubleArray(year * 12 + month)
            var balanceOfPayment = initialSum
            for (i in 0 until year * 12 + month) {
                arrayOfMonthlyInstallment[i] = initialSum / (year * 12 + month) + interestRate / 100 / 12 * balanceOfPayment
                balanceOfPayment -= initialSum / (year * 12 + month)
            }
            for (j in 0 until year * 12 + month) {
                total += arrayOfMonthlyInstallment[j]
            }
        }
        interestCharge = total - initialSum
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
}