package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinSumInfinite {

  public static void main(String[] args) {
    CoinSumInfinite coinSumInfinite = new CoinSumInfinite();
    List<Integer> list = Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8); //Arrays.asList(1,2,3);
    ArrayList<Integer> A = new ArrayList<>();
    A.addAll(list);
    int B=458; //4;
    coinSumInfinite.coinchange2(A,B);
    System.out.println(coinSumInfinite.totalPossibleWays);
//    int[] s = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
//    System.out.println(countWays(s,s.length,B));
  }

  int totalPossibleWays=0;

  Set<String> set = new HashSet<>();

  public int coinchange2(ArrayList<Integer> A, int B) {
    return countWays(A, A.size(),B);
  }

  private void coinChange(ArrayList<Integer> A, int B, List<Integer> list){
    if(B==0){
      Collections.sort(list);
      String key = list.toString();
      if(!set.contains(key)){
        totalPossibleWays = (totalPossibleWays+1)%1000007;
        set.add(key);
      }
      return;
    }
    for(int i=0; i<A.size(); i++){
      if(A.get(i) <= B){
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(A.get(i));
        coinChange(A,B-A.get(i),newList);
      }
    }
  }


  static long countWays(int S[], int m, int n)
  {
    //Time complexity of this function: O(mn)
    //Space Complexity of this function: O(n)

    // table[i] will be storing the number of solutions
    // for value i. We need n+1 rows as the table is
    // constructed in bottom up manner using the base
    // case (n = 0)
    long[] table = new long[n+1];

    // Initialize all table values as 0
    Arrays.fill(table, 0);   //O(n)

    // Base case (If given value is 0)
    table[0] = 1;

    // Pick all coins one by one and update the table[]
    // values after the index greater than or equal to
    // the value of the picked coin
    for (int i=0; i<m; i++)
      for (int j=S[i]; j<=n; j++)
        table[j] = (table[j] + table[j-S[i]])%1000007;

    return table[n];
  }

  int countWays(ArrayList<Integer> S, int m, int n)
  {
    int[] table = new int[n+1];
    Arrays.fill(table, 0);
    table[0] = 1;
    for (int i=0; i<m; i++)
      for (int j=S.get(i); j<=n; j++)
        table[j] = (table[j] + table[j-S.get(i)])%1000007;

    return table[n];
  }

}
