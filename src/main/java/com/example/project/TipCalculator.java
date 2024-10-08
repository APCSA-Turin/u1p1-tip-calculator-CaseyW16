package com.example.project;

public class TipCalculator {

    public static String formatMoney(double decimal) {
        decimal = Math.round(decimal * 100) / 100.0;
        String str = "$" + Double.toString(decimal);
        boolean onesPlace = decimal == (double)((int)decimal);
        boolean tenthsPlace = decimal * 10 == (double)((int)(decimal * 10));
        if (onesPlace || tenthsPlace) str += "0";
        return str + "\n";
    }

    public static String calculateTip(int people, int percent, double cost) { // You must use these  variable in your calculations
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

        return result.toString();
    }
     // TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        // try different values for people, percent, and cost to test your program before running test cases
        int people = 12;
        int percent = 15;
        double cost = 566.97;
    
        System.out.println(calculateTip(people, percent, cost));
    }
}
        
