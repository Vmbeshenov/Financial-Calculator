package com.vmb.financialcalculator;

public class Credit {

    double first_sum;
    double interest_rate;
    int year;
    int month;

    double total;
    double interest_charge;
    double monthly_installment;

    public Credit() {
        first_sum = 0;
        interest_rate = 0;
        year = 0;
        month = 0;

        total = 0;
        interest_charge = 0;
        monthly_installment = 0;
    }

    public void CalculateCredit(boolean payment_type_annuity) {

        if (payment_type_annuity) {
            double interest_rate_1 = 1 + (interest_rate / 100 / 12);
            double total_interest_rate = interest_rate_1;
            for (int i = 0; i < (year * 12 + month) - 1; i++) {
                total_interest_rate *= interest_rate_1;
            }
            monthly_installment = first_sum * ((interest_rate / 100 / 12) + (interest_rate / 100 / 12) / (total_interest_rate - 1));
            total = monthly_installment * (year * 12 + month);
        }

        else {
            double[] monthly_installment_array = new double[(year * 12 + month)];
            double balance_of_payment = first_sum;
            for (int i = 0; i < (year * 12 + month); i++) {
                monthly_installment_array[i] = (first_sum / (year * 12 + month)) + ((interest_rate / 100 / 12) * balance_of_payment);
                balance_of_payment -= first_sum / (year * 12 + month);
            }
            for (int j = 0; j < (year * 12 + month); j++) {
                total += monthly_installment_array[j];
            }
        }

        interest_charge = total - first_sum;
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
