package com.vmbeshenov.financialcalculator

import java.io.Serializable

class Credit : Serializable {

    var initialSum = 2000000.0
    var interestRate = 12.50
    var year = 10
    var month = 0

    var total = 0.0
        private set
    var interestCharge = 0.0
        private set
    var monthlyInstallment = 0.0
        private set

    //Аннуитетный тип платежа
    fun calculateCredit() {
        val interestRateForOneMonth = 1 + interestRate / 100 / 12
        var finalInterestRate = interestRateForOneMonth
        for (i in 0 until year * 12 + month - 1) {
            finalInterestRate *= interestRateForOneMonth
        }
        monthlyInstallment = initialSum * (interestRate / 100 / 12 + interestRate / 100 / 12 / (finalInterestRate - 1))
        total = monthlyInstallment * (year * 12 + month)
        interestCharge = total - initialSum
    }
}