package com.practice.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {


  private static int countLengthOfLIS(int[] a, int i, int lastElement){
    if(i >= a.length){
      return 0;
    }
    if(a[i] > lastElement){
      return Math.max(1+ countLengthOfLIS(a,i+1,a[i]), countLengthOfLIS(a,i+1,lastElement) );
    }
    else {
      return countLengthOfLIS(a,i+1,lastElement);
    }
  }

  public static void main(String[] args) {
    int[] a = {8,9,1,7,2,10,3,4,30,60};

    System.out.println(countLengthOfLIS(a,0,0));
    List<Integer> list = new ArrayList<>();
    Collections.sort(list);
  }

}
