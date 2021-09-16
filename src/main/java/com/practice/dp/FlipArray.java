package com.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SumAndFlips{
  int sum;
  int flip;

  public SumAndFlips(int sum, int flip) {
    this.sum = sum;
    this.flip = flip;
  }
}

public class FlipArray {

  private Map<String, SumAndFlips> map = new HashMap<>();

  public static void main(String[] args) {
    FlipArray flipArray = new FlipArray();
    List<Integer> A = Arrays.asList(11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3);
//    List<Integer> A = Arrays.asList(4,10,3,4,2);
    System.out.println(flipArray.solve(A));
  }

  public int solve(final List<Integer> A) {
    int sum=0;
    for(int i=0;i<A.size();i++){
      sum += A.get(i);
    }
    SumAndFlips sumAndFlips= minSum(A,sum/2,0);
    return sumAndFlips.flip;
  }

  private SumAndFlips minSum(final List<Integer> A, int capacity, int i){
    if(i>=A.size() || capacity<=0){
      return new SumAndFlips(capacity,0);
    }
    String key = capacity+":"+i;
    if(map.get(key)!=null){
      return map.get(key);
    }
    SumAndFlips withOutFilp = minSum(A,capacity,i+1);

    int num = A.get(i);
    int newSum =capacity-num;
    if(newSum<0){
      map.put(key,withOutFilp);
      return withOutFilp;
    }
    SumAndFlips flipSum = minSum(A,newSum,i+1);
    flipSum.flip=1+flipSum.flip;
    if(flipSum.sum < withOutFilp.sum){
      map.put(key,flipSum);
      return flipSum;
    }
    else if(flipSum.sum == withOutFilp.sum){
      if(flipSum.flip < withOutFilp.flip){
        map.put(key,flipSum);
        return flipSum;
      }
      map.put(key,withOutFilp);
      return withOutFilp;
    }
    map.put(key,withOutFilp);
    return withOutFilp;
  }



  public static int solve1( List<Integer> A, int n)
  {
    int[][] dp = new int[2000][2000];
    // boolean variable used for
    // toggling between maps
    int flag = 1;

    // Calculate the sum of all
    // elements of the array
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += A.get(i);

    // Initializing first map(dp[0])
    // with INT_MAX because for i=0,
    // there are no elements in the
    // array to flip
    for (int i = -sum; i <= sum; i++) {
      try {
        dp[0][i] = Integer.MAX_VALUE;
      }
      catch (Exception e) {
      }
    }

    // Base Case
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        try {
          dp[flag][j] = Integer.MAX_VALUE;
          if (j - A.get(i - 1) <= sum
              && j - A.get(i - 1) >= -sum)
            dp[flag][j]
                = dp[flag ^ 1][j - A.get(i - 1)];
          if (j + A.get(i - 1) <= sum
              && j + A.get(i - 1) >= -sum
              && dp[flag ^ 1][j + A.get(i - 1)]
              != Integer.MAX_VALUE)
            dp[flag][j] = Math.min(
                dp[flag][j],
                dp[flag ^ 1][j + A.get(i - 1)] + 1);
        }
        catch (Exception e) {
        }
      }

      // For toggling
      flag = flag ^ 1;
    }

    // Required sum is minimum non-negative
    // So, we iterate from i=0 to sum and find
    // the first i where dp[flag ^ 1][i] != INT_MAX
    for (int i = 0; i <= sum; i++) {
      if (dp[flag ^ 1][i] != Integer.MAX_VALUE)
        return dp[flag ^ 1][i];
    }

    // In worst case we will flip max n-1 elements
    return n - 1;
  }

}
