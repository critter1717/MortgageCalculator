package com.mortgage.console;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        System.out.println("Welcome to the mortgage calculator!");
        int principal = (int) Console.readNumber("Enter Principal Amount (Total House Cost After Down Payment): ", 1000, 1_000_000);
        double deposit = (float) Console.readNumber("Enter Down Payment Placed: ", 1000, 1_000_000);
        double annualInterest = (float) Console.readNumber("Annual Interest Rate (As a Percentage): ", 1, 35);
        int years = (int) Console.readNumber("Enter Time Period For Payment in Years: ", 1, 35);

        var mortgageCalculator = new Calculator(principal, deposit, annualInterest, years);
        var mortgageReport = new Report(mortgageCalculator);

        mortgageReport.printMonthlyMortgage();
        mortgageReport.printPaymentSchedule();
    }
}