package com.example.project;
import java.util.Scanner;

public class ExtraCredit {
    // WRITE YOUR PROGRAM IN calculateTip

    public static String formatMoney(double decimal) {
        decimal = Math.round(decimal * 100) / 100.0;
        String str = "$" + Double.toString(decimal);
        boolean onesPlace = decimal == (double)((int)decimal);
        boolean tenthsPlace = decimal * 10 == (double)((int)(decimal * 10));
        if (onesPlace || tenthsPlace) str += "0";
        return str + "\n";
    }

    public static String calculateTip(int people, int percent, double cost, String items) { // You must use these  variable in your calculations
        // DO NOT DELETE ANY OF THE CODE BELOW      
        StringBuilder result = new StringBuilder();

        double tip = Math.round(cost * percent) / 100.0; // I learned this method of rounding here: https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/
        double perPersonBeforeTip = cost / people;       
        double tipsPerPerson = 0.01 * (cost * percent) / people;   
        double totalCostPerPerson = perPersonBeforeTip + tipsPerPerson;  

        result.append("-------------------------------\n");
        result.append("Total bill before tip: " + formatMoney(cost)); // concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%\n");
        result.append("Total tip: " + formatMoney(tip));
        result.append("Total Bill with tip: " + formatMoney(cost + tip));
        result.append("Per person cost before tip: " + formatMoney(perPersonBeforeTip));
        result.append("Tip per person: " + formatMoney(tipsPerPerson));
        result.append("Total cost per person: " + formatMoney(totalCostPerPerson));
        result.append("-------------------------------\n");
        result.append("Items ordered: \n" + items);

        return result.toString();
    }
     // TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many people are in your party? ");
        int people = scan.nextInt();

        System.out.print("What percent tip? ");
        int percent = scan.nextInt();

        System.out.print("How much did your meal cost? $");
        double cost = scan.nextDouble();

        scan.nextLine();
        String order = "";
        String items = "";
        while (true) {
            System.out.print("Enter an item name or type '-1' to finish: ");
            order = scan.nextLine();
            if (order.equals("-1")) break;
            items += order + "\n";
        }

        scan.close();
        System.out.println(calculateTip(people, percent, cost, items));
    }
}