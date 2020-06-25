package com.vmb.financialcalculator;

import java.io.Serializable;

public class Credit implements Serializable {

    private double initial_sum;
    private double interest_rate;
    private int year;
    private int month;

    private double total;
    private double interest_charge;
    private double monthly_installment;

    public Credit() {
        initial_sum = 0;
        interest_rate = 0;
        year = 0;
        month = 0;

        total = 0;
        interest_charge = 0;
        monthly_installment = 0;
    }

    public void CalculateCredit(boolean payment_type_annuity) {

        if (payment_type_annuity) {
            double interest_rate_one_month = 1 + (interest_rate / 100 / 12);
            double total_interest_rate = interest_rate_one_month;
            for (int i = 0; i < (year * 12 + month) - 1; i++) {
                total_interest_rate *= interest_rate_one_month;
            }
            monthly_installment = initial_sum * ((interest_rate / 100 / 12) + (interest_rate / 100 / 12) / (total_interest_rate - 1));
            total = monthly_installment * (year * 12 + month);
        }

        else {
            double[] monthly_installment_array = new double[(year * 12 + month)];
            double balance_of_payment = initial_sum;
            for (int i = 0; i < (year * 12 + month); i++) {
                monthly_installment_array[i] = (initial_sum / (year * 12 + month)) + ((interest_rate / 100 / 12) * balance_of_payment);
                balance_of_payment -= initial_sum / (year * 12 + month);
            }
            for (int j = 0; j < (year * 12 + month); j++) {
                total += monthly_installment_array[j];
            }
        }

        interest_charge = total - initial_sum;
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


    public double getTotal() {
        return total;
    }

    public double getInterest_charge() {
        return interest_charge;
    }

    public double getMonthly_installment() {
        return monthly_installment;
    }
}
