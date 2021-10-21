package com.practice.bitmanipulation;

/*
Given an integer A, count and return the number of trailing zeroes.
 */

public class TrailingZeroes {

  public int solve(int A) {
    int n=0;
    int one=1;
    int and =A&one;
    while(and!= 1){
      n++;
      A = A>>1;
      and =A&one;
    }
    return n;
  }

}
