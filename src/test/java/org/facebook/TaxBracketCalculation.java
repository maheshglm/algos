package org.facebook;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//https://algorithms.tutorialhorizon.com/calculate-tax-on-income-as-per-given-tax-brackets/
public class TaxBracketCalculation {

    static class TaxBracket {
        Integer limit;
        double tax;

        public TaxBracket(Integer limit, double tax) {
            this.limit = limit;
            this.tax = tax;
        }
    }

    private static double getTaxAmount(int income, List<TaxBracket> brackets) {
        double totalTax = 0;
        int taxableIncome;
        for (TaxBracket taxslab : brackets) {
            Integer slabLimit = taxslab.limit;
            double slabTax = taxslab.tax;
            if (slabLimit != null) {
                taxableIncome = Math.min(income, slabLimit);
                totalTax += taxableIncome * slabTax;
                income = income - taxableIncome;
            } else {
                totalTax += income * slabTax;
            }

            if (income <= 0) break;
        }
        return totalTax;
    }

    private static double getTaxAmount(Integer income, LinkedHashMap<Integer, Double> taxSlabs) {
        double taxAmount = 0;
        int taxableIncome;

        for (Map.Entry<Integer, Double> slab : taxSlabs.entrySet()) {
            Integer slabLimit = slab.getKey();
            double slabTax = slab.getValue();

            if (slabLimit != null) {
                taxableIncome = Math.min(income, slabLimit);
                taxAmount += taxableIncome * slabTax;
                income = income - taxableIncome;
            } else {
                taxAmount += income * slabTax;
            }

            if (income <= 0) break;
        }

        return taxAmount;
    }


    public static void main(String[] args) {

//        List<TaxBracket> taxBrackets = new ArrayList<>();
//        taxBrackets.add(new TaxBracket(10000, 0.1));
//        taxBrackets.add(new TaxBracket(20000, 0.2));
//        taxBrackets.add(new TaxBracket(15000, 0.3));
//        taxBrackets.add(new TaxBracket(null, 0.5));
//
//        double taxAmount1 = getTaxAmount(100000, taxBrackets);
//        System.out.println(taxAmount1); //expected = 37000.0
//
//        double taxAmount2 = getTaxAmount(10000, taxBrackets);
//        System.out.println(taxAmount2); //expected = 1000.0
//
//        double taxAmount3 = getTaxAmount(35000, taxBrackets);
//        System.out.println(taxAmount3); //expected = 6500
//
//        double taxAmount4 = getTaxAmount(50000, taxBrackets);
//        System.out.println(taxAmount4); //expected = 12000


        //Another way to define slabs
        LinkedHashMap<Integer, Double> taxSlabs = new LinkedHashMap<>();
        taxSlabs.put(10000, 0.1);
        taxSlabs.put(20000, 0.2);
        taxSlabs.put(15000, 0.3);
        taxSlabs.put(null, 0.5);

        double taxAmount1 = getTaxAmount(100000, taxSlabs);
        System.out.println(taxAmount1); //expected = 37000.0

        double taxAmount2 = getTaxAmount(10000, taxSlabs);
        System.out.println(taxAmount2); //expected = 1000.0

        double taxAmount3 = getTaxAmount(35000, taxSlabs);
        System.out.println(taxAmount3); //expected = 6500.0

        double taxAmount4 = getTaxAmount(50000, taxSlabs);
        System.out.println(taxAmount4); //expected = 12000.0
    }
}
