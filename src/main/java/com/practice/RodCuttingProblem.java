package com.practice;

public class RodCuttingProblem {

  private static int maxProfit(int[] value){
    int n= value.length;
    int[] subProblems = new int[n];
    subProblems[0] = value[0];
    int i=1;
    while (i<n){
      int max = value[i];
      for(int j=0; j<i; j++){
        max = Math.max(value[j]+subProblems[i-j-1], max);
      }
      subProblems[i] =  max;
      i++;
    }
    return subProblems[n-1];
  }

  public static void main(String[] args) {
//    int[] a = {1,5,8,9,10,17,17,20};
    int[] a = {3,5,8,9,10,17,17,20};
    System.out.println(maxProfit(a));
  }

}
