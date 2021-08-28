/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */
package com.practice.dp;

import java.util.List;

public class BestTimeToBuyAndSellStocksI {


  public int maxProfit(final List<Integer> A) {
    int leftLowestValue=Integer.MAX_VALUE;
    int maxProfit=0;
    int n=A.size();
    for(int i =0; i<n; i++){
      if(leftLowestValue > A.get(i)){
        leftLowestValue = A.get(i);
      }
      int posiblePofit = A.get(i)-leftLowestValue;
      if(posiblePofit > maxProfit){
        maxProfit = posiblePofit;
      }
    }
    return maxProfit;
  }


}
