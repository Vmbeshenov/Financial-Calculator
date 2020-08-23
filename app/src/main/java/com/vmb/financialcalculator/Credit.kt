package com.vmb.financialcalculator

import java.io.Serializable

class Credit : Serializable {
    private var initial_sum = 0.0
    private var interest_rate = 0.0
    private var year = 0
    private var month = 0
    var total = 0.0
        private set
    var interest_charge = 0.0
        private set
    var monthly_installment = 0.0
        private set

    fun CalculateCredit(payment_type_annuity: Boolean) {
        if (payment_type_annuity) {
            val interest_rate_one_month = 1 + interest_rate / 100 / 12
            var total_interest_rate = interest_rate_one_month
            for (i in 0 until year * 12 + month - 1) {
                total_interest_rate *= interest_rate_one_month
            }
            monthly_installment = initial_sum * (interest_rate / 100 / 12 + interest_rate / 100 / 12 / (total_interest_rate - 1))
            total = monthly_installment * (year * 12 + month)
        } else {
            val monthly_installment_array = DoubleArray(year * 12 + month)
            var balance_of_payment = initial_sum
            for (i in 0 until year * 12 + month) {
                monthly_installment_array[i] = initial_sum / (year * 12 + month) + interest_rate / 100 / 12 * balance_of_payment
                balance_of_payment -= initial_sum / (year * 12 + month)
            }
            for (j in 0 until year * 12 + month) {
                total += monthly_installment_array[j]
            }
        }
        interest_charge = total - initial_sum
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

}