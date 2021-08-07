package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumbersOfLengthNAndValueLessThanK {

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(0, 1, 2, 5);
    System.out.println(solve(A,3,216));
  }

  private  static List<Integer> numToList(int num){
    List<Integer>  digit = new ArrayList<>();;
    while (num>0){
      int rem = num%10;
      num = num/10;
      digit.add(rem);
    }
    Collections.reverse(digit);
    return digit;
  }
  // Function to return the count
// of B length integers which are
// less than C and they contain
// digits from set A[] only
  static int solve(List<Integer> A, int B, int C)
  {
    List<Integer> digit = new ArrayList<>();
    int d, d2;

    // Convert number to digit array
    digit = numToList(C);
    d = A.size();

    // Case 1: No such number possible as the
    // generated numbers will always
    // be greater than C
    if (B > digit.size() || d == 0)
      return 0;

      // Case 2: All integers of length B are valid
      // as they all are less than C
    else if (B < digit.size())
    {
      // contain 0
      if (A.get(0) == 0 && B != 1)
        return (int) ((d - 1) * Math.pow(d, B - 1));
      else
        return (int) Math.pow(d, B);
    }

    // Case 3
    else
    {
      int MAX =10;
      int []dp = new int[B + 1];
      int []lower = new int[MAX+1];

      // Update the lower[] array such that
      // lower[i] stores the count of elements
      // in A[] which are less than i
      for (int i = 0; i < d; i++)
        lower[A.get(i) + 1] = 1;
      for (int i = 1; i <= MAX; i++)
        lower[i] = lower[i - 1] + lower[i];

      boolean flag = true;
      dp[0] = 0;
      for (int i = 1; i <= B; i++)
      {
        d2 = lower[digit.get(i - 1)];
        dp[i] = dp[i - 1] * d;

        // For first index we can't use 0
        if (i == 1 && A.get(0) == 0 && B != 1)
          d2 = d2 - 1;

        // Whether (i-1) digit of generated number
        // can be equal to (i - 1) digit of C
        if (flag)
          dp[i] += d2;

        // Is digit[i - 1] present in A ?
        flag = (flag & (lower[digit.get(i - 1) + 1] ==
            lower[digit.get(i - 1)] + 1));
      }
      return dp[B];
    }
  }




  public static int solve1(List<Integer> A, int B, int C) {
    int N =B;
    int K=C;// value less than k of length N;
    int d =A.size();
    int num = K;
    int lenK=0;
    List<Integer>  digit = new ArrayList<>();;

    while (num>=0){
      int rem = num%10;
      digit.add(rem);
      num = num/10;
      lenK++;
    }
    System.out.println("length of K:"+lenK);
    if(lenK < N){
      return 0;
    }
    int result =1;
    if(lenK > N){
      if(A.get(0)==0){
        result = d-1;
        int i=0;
        while (i<N-1){
          result *= d;
          i++;
        }
      }
      else{
        int i=0;
        while (i<N){
          result *= d;
          i++;
        }
      }
      return result;
    }

    // Case 3
    else
    {
    //  Collections.sort(digit);
      int MAX = 11;
      int []dp = new int[B + 1];
      int []lower = new int[MAX + 1];

      // Update the lower[] array such that
      // lower[i] stores the count of elements
      // in A[] which are less than i
      for (int i = 0; i < d; i++)
        lower[A.get(i) + 1] = 1;
      for (int i = 1; i <= MAX; i++)
        lower[i] = lower[i - 1] + lower[i];

      boolean flag = true;
      dp[0] = 0;
      for (int i = 1; i <= B; i++)
      {
        int d2 = lower[digit.get(i - 1)];
        dp[i] = dp[i - 1] * d;

        // For first index we can't use 0
        if (i == 1 && A.get(0) == 0 && B != 1)
          d2 = d2 - 1;

        // Whether (i-1) digit of generated number
        // can be equal to (i - 1) digit of C
        if (flag)
          dp[i] += d2;

        // Is digit[i - 1] present in A ?
        flag = (flag & (lower[digit.get(i - 1) + 1] ==
            lower[digit.get(i - 1)] + 1));
      }
      return dp[B];
    }

  }


  public static int solve2(ArrayList<Integer> A, int B, int C) {
    int n=A.size();
    int highestNum = 0;
    int b =B;
    while (b>=0){
      highestNum += A.get(n-1)*Math.pow(10,b);
      b--;
    }
    System.out.println("highest:"+highestNum);
    int iLow =0;
    int lowestNum = 0;
    if(A.get(iLow)==0){
      iLow++;
      lowestNum += A.get(iLow)*Math.pow(10,b);
    }
    else {
      b =B;
      while (b>=0){
        lowestNum += A.get(iLow)*Math.pow(10,b);
        b--;
      }
    }
    if(lowestNum > C){
      return 0;
    }
    return C-lowestNum;
  }

}
