package com.mortgage.console;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {


        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        double deposit = (float) Console.readNumber("Deposit: ", 1000, 1_000_000);
        double annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 35);
        int years = (int) Console.readNumber("Period (years):", 1, 35);

        var mortgageCalculator = new Calculator(principal, deposit, annualInterest, years);
        var mortgageReport = new Report(mortgageCalculator);

        mortgageReport.printMonthlyMortgage();
        mortgageReport.printPaymentSchedule();
    }
}