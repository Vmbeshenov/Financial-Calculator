package com.vmb.financialcalculator

import java.io.Serializable

class Deposit : Serializable {
    private var initial_sum = 0.0
    private var interest_rate = 0.0
    private var year = 0
    private var month = 0
    private var additional_sum = 0.0
    var total = 0.0
        private set
    var profit = 0.0
        private set
    var additional_sum_total = 0.0
        private set

    fun CalculateDeposit(capitalization: Boolean) {
        if (!capitalization) {
            total = initial_sum
            for (i in 0 until year) {
                total += total * interest_rate / 100 + additional_sum
                additional_sum_total += additional_sum
            }
            total += total * interest_rate / 100 / 12 * month
        }
        if (capitalization) {
            total = initial_sum
            for (j in 0 until year * 12 + month) {
                total += total * interest_rate / 100 / 12 + additional_sum
                additional_sum_total += additional_sum
            }
        }
        profit = total - initial_sum - additional_sum_total
    }

    fun setInitial_sum(initial_sum: Double) {
        this.initial_sum = initial_sum
    }

    fun setInterest_rate(interest_rate: Double) {
        this.interest_rate = interest_rate
    }

    fun setYear(year: Int) {
        this.year = year
    }

    fun setMonth(month: Int) {
        this.month = month
    }

    fun setAdditional_sum(additional_sum: Double) {
        this.additional_sum = additional_sum
    }

    fun setInitial_sum(initial_sum: String) {
        this.initial_sum = initial_sum.toDouble()
    }

    fun setInterest_rate(interest_rate: String) {
        this.interest_rate = interest_rate.toDouble()
    }

    fun setYear(year: String) {
        this.year = year.toInt()
    }

    fun setMonth(month: String) {
        this.month = month.toInt()
    }

    fun setAdditional_sum(additional_sum: String) {
        this.additional_sum = additional_sum.toDouble()
    }

}