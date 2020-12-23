package org.facebook;

import org.junit.Test;

//https://www.youtube.com/watch?v=3RHCb8LY-X4
public class MaxProfit {


    private int solution(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        int minBuyPrice = -1;
        int maxSellPrice = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else if (maxProfit < prices[i] - minBuy) {
                maxProfit = prices[i] - minBuy;
                minBuyPrice = minBuy;
                maxSellPrice = prices[i];
            }
        }
        System.out.println("min buy price " + minBuyPrice);
        System.out.println("max sell price " + maxSellPrice);
        return maxProfit;
    }

    private int solution1(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int profit = 0;
        int maxSell = 0;
        for (int price : prices) {
            if (price < minBuy) {
                minBuy = price;
            } else {
                if (price - minBuy > profit) {
                    profit = price - minBuy;
                    maxSell = price;
                }
            }
        }
        System.out.println("MinBuy " + minBuy);
        System.out.println("MaxSell " + maxSell);
        return profit;
    }

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //output = 6 - 1 = 5
        //System.out.println(solution(prices));
        System.out.println(solution1(prices));
    }

    @Test
    public void test2() {
        int[] prices = {8, 5, 12, 9, 19, 1};
        //output = 14
        //System.out.println(solution(prices));
        System.out.println(solution1(prices));
    }

}
