package com.mortgage.console;

import java.text.NumberFormat;

public class Report {


    private final Calculator calculator;
    private final NumberFormat currency;


    public Report(Calculator calculator) {
        this.calculator = calculator;
        this.currency = NumberFormat.getCurrencyInstance();
    }
    public void printMonthlyMortgage() {
        double monthlyPayment = calculator.calculateMortgage();
        String monthlyPaymentFormatted = currency.format(monthlyPayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Your monthly payment is: " + monthlyPaymentFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (double balance : calculator.getRemainingBalances()) {
            System.out.println(currency.format(balance));
        }
    }

}
