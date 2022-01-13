package com.practice;

public class SlidingWindowProblems {

  private static int findMaxSumOfKConsicutive(int[] a, int k){
    int windSum = 0;
    int n = a.length;
    for (int i=0;i<k;i++){
      windSum += a[i];
    }
    int maxSum = windSum;
    for(int i=k;i<n;i++){
      windSum += a[i] - a[i-k];
      maxSum = Math.max(windSum,maxSum);
    }
    return maxSum;
  }


  public static void main(String[] args) {
    int[] a = {1,2,3,4,5,6,7,-8,9};
    System.out.println(findMaxSumOfKConsicutive(a,4));
  }
}
