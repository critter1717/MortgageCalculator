package com.mortgage.console;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

//    overloading for practice
//    public static double readNumber(String promt) {
//        return scanner.nextDouble();
//    }
    public static double readNumber(String promt, double min, double max) {
        Scanner person = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(promt);
            try{
                value = person.nextDouble();
                if (value <= min || value >= max) {
                    throw new ArithmeticException();
                }
                return value;
            }
            catch(ArithmeticException e){
                System.out.println("Enter value between " + min + " and " + max);
            }





        }
    }
}
