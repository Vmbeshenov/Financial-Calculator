package com.vmb.financialcalculator;

import java.io.Serializable;

public class Deposit implements Serializable {

    private double initial_sum;
    private double interest_rate;
    private int year;
    private int month;
    private double additional_sum;

    private double total;
    private double profit;
    private double additional_sum_total;

    public Deposit() {
        initial_sum = 0;
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
            total = initial_sum;
            for (int i = 0; i < year; i++) {
                total += total * interest_rate / 100 + additional_sum;
                additional_sum_total += additional_sum;
            }
            total += total * interest_rate / 100 / 12 * month;
        }

        if(capitalization) {
            total = initial_sum;
            for (int j = 0; j < (year * 12 + month); j++){
                total += total * interest_rate / 100 / 12 + additional_sum;
                additional_sum_total += additional_sum;
            }
        }
        profit = total - initial_sum - additional_sum_total;
    }

    public void setInitial_sum(double initial_sum) {
        this.initial_sum = initial_sum;
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


    public void setInitial_sum(String initial_sum) {
        this.initial_sum = Double.parseDouble(initial_sum);
    }

    public void setInterest_rate(String interest_rate) {
        this.interest_rate = Double.parseDouble(interest_rate);
    }

    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }

    public void setMonth(String month) {
        this.month = Integer.parseInt(month);
    }

    public void setAdditional_sum(String additional_sum) {
        this.additional_sum = Double.parseDouble(additional_sum);
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
