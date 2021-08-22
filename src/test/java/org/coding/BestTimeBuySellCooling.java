package org.coding;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeBuySellCooling {

    //According to the state machine we defined before,
    // we can then deduce the formulas to calculate the values for the state arrays, as follows:
    //

    //sold[i]=hold[i−1]+price[i]
    //held[i]=max(held[i−1],reset[i−1]−price[i])
    //reset[i]=max(reset[i−1],sold[i−1])
    //
    //Here is how we interpret each formulas:
    //
    //sold[i]: the previous state of sold can only be held.
    // Therefore, the maximal profits of this state is the maximal profits of the previous state
    // plus
    // the revenue by selling the stock at the current price.
    //
    //held[i]: the previous state of held could also be held, i.e. one does no transaction.
    //Or its previous state could be reset, from which state,
    //one can acquire a stock at the current price point.
    //
    //reset[i]: the previous state of reset could either be reset or sold.
    //Both transitions do not involve any transaction with the stock.

    //Maxprofit is Math.max(reset[i], sold[i])

    private int solution(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int noStock = 0;

        for (int price : prices) {
            int tempSold = sold; //as noStock is depends on previous day sold, we are taking into temp variable
            sold = sold + price; //sold should be updated first as it is independent
            held = Math.max(held, noStock - price);//held is not dependent on noStock
            noStock = Math.max(tempSold, noStock);
        }
        return Math.max(noStock, sold);
    }

}

