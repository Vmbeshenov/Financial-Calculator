package com.vmbeshenov.financialcalculator

import java.io.Serializable

class Deposit : Serializable {

    var initialSum: Double = 100000.0
    var interestRate: Double = 7.75
    var year = 5
    var month = 0
    var additionalPayment: Double = 0.0

    var capitalization = false

    var total: Double = 0.0
        private set
    var profit: Double = 0.0
        private set
    var amountOfAdditionalPayments: Double = 0.0
        private set

    fun calculateDeposit() {

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
}