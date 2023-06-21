package com.mortgage.console;

import com.mortgage.console.Main;

public class Calculator {

    private final static int MONTH_IN_YEAR = 12;
    private final static int PERCENT = 100;
    private final int principal;

    private final double deposit;
    private final double annualInterest;
    private final int years;


    public Calculator(int principal,double deposit, double annualInterest, int years) {
        this.principal = principal;
        this.deposit = deposit;
        this.annualInterest = annualInterest;
        this.years = years;
    }


    public double calculateBalance(short numberOfPaymentsMade) {

        int numberOfPayments = getNumberOfPayments();
        double monthlyInterest = getMonthlyInterest();
        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        int numberOfPayments = getNumberOfPayments();
        double monthlyInterest = getMonthlyInterest();

        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);
        double monthlyPayment = (principal - deposit) * (monthlyInterest * mathPower / (mathPower - 1));

        return monthlyPayment;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month -1] = calculateBalance(month);
        }
        return balances;
    }


    private double getMonthlyInterest() {
        return annualInterest / PERCENT / MONTH_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }
}
