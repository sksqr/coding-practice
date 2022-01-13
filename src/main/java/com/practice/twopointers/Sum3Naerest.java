package com.practice.twopointers;
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.

Return the sum of the three integers.

Assume that there will only be one solution

Example:

given array S = {-1 2 1 -4},

and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */

import java.util.ArrayList;
import java.util.Collections;

public class Sum3Naerest {

  public int threeSumClosest(ArrayList<Integer> A, int B) {
    Collections.sort(A);

    int sum=Integer.MAX_VALUE;
    for(int i=0; i<A.size(); i++){

      int a = A.get(i);
      int s= i+1;
      int e = A.size()-1;
      while(s<e){
        int b = A.get(s);
        int c = A.get(e);
        int tempSum = a+b+c;
        if(sum == Integer.MAX_VALUE){
          sum = tempSum;
        }
        if(Math.abs(B-tempSum) < Math.abs(B-sum)){
          sum = tempSum;
        }
        if(tempSum==B){
          return tempSum;
        }
        else if(tempSum < B){
          s++;
        }
        else{
          e--;
        }
      }
    }
    return sum;
  }


}
