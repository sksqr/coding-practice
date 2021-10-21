package com.practice.twopointers;

import java.util.ArrayList;

/*
Given an array ‘A’ of sorted integers and another non negative integer k,
 find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 */
public class Diffk {

  public int diffPossible(ArrayList<Integer> A, int B) {
    int first=0;
    int second =0;
    int n=A.size();
    if(n<=1){
      return 0;
    }
    while(first<n && second<n){
      int diff = A.get(second) - A.get(first);
      if(diff==B && first!=second){
        return 1;
      }
      else if(diff < B){
        second++;
      }
      else{
        first++;
      }
    }
    return 0;
  }

}
