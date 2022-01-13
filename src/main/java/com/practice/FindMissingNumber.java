package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumber {

  static public long findOneMissingNumber(List<Integer> a){
    int n =  a.size()+1;
    long sum1 = (n*(n+1))/2;
    long sum2 = 0;
    for(Integer num:a){
      sum2+=num;
    }
    return sum1-sum2;
  }

  static public long findTwoMissingNumber(List<Integer> a){
    int n =  a.size()+2;
    long sum1 = (n*(n+1))/2;
    long sum2 = 0;
    for(Integer num:a){
      sum2+=num;
    }
    //x+y= sum1-sum2;
    // avg = (x+y)/2;
    // one of x and y will be less than avg and another will be greater than avg;
    //Search one missing number from 0 to avg And another missing number from avg to n;

    return -1;
  }



  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,6,7,8));
    System.out.println(findOneMissingNumber(a));
  }

}
