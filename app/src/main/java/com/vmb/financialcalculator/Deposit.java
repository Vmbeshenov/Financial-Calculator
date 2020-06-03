package com.vmb.financialcalculator;

public class Deposit {

    double first_sum;
    double interest_rate;
    int year;
    int month;
    double additional_sum;

    double total;
    double profit;
    double additional_sum_total;

    public Deposit() {
        first_sum = 0;
        interest_rate = 0;
        year = 0;
        month = 0;
        additional_sum = 0;

        total = 0;
        profit = 0;
        additional_sum_total = 0;
    }

    public void CalculateDeposit(boolean capitalization){
        if (!capitalization) {
            total = first_sum;
            for (int i = 0; i < year; i++) {
                total += total * interest_rate / 100 + additional_sum;
                additional_sum_total += additional_sum;
            }
            total += total * interest_rate / 100 / 12 * month;
        }

        if(capitalization) {
            total = first_sum;
            for (int j = 0; j < (year * 12 + month); j++){
                total += total * interest_rate / 100 / 12 + additional_sum;
                additional_sum_total += additional_sum;
            }
        }
        profit = total - first_sum - additional_sum_total;
    }

    public void setFirst_sum(double first_sum) {
        this.first_sum = first_sum;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setAdditional_sum(double additional_sum) {
        this.additional_sum = additional_sum;
    }

    public double getFirst_sum() {
        return first_sum;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public double getAdditional_sum() {
        return additional_sum;
    }


    public double getTotal() {
        return total;
    }

    public double getProfit() {
        return profit;
    }

    public double getAdditional_sum_total() {
        return additional_sum_total;
    }
}
