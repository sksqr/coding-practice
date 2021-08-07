package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PairWithGivenDifference {

  public static void main(String[] args) {
//    List<Integer> A = Arrays.asList(5, 10, 3, 2, 50, 80);
    List<Integer> A = Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322 );
    int B = 369;

//    List<Integer> A = Arrays.asList(-259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398 );
//    int B= -42;

//    System.out.println(sumExist(A,B));
    System.out.println(solve(A,B));
  }

  public static int  solve(List<Integer> A, int B) {
    Set<Integer> set = new HashSet<>();

    A.forEach(a -> set.add(a));
    int i=0;
    while (i<A.size()){
      if(set.contains(A.get(i)+B)){
        return 1;
      }
      i++;
    }
    return 0;

  }

  public static int binarySearch(List<Integer> A, int low, int high, int num){
    if(low >= high){
      return 0;
    }
    int mid = low+ (high - low)/2;   // (low+high)/2 = low + (high-low)/2
    if(A.get(mid) == num){
      return 1;
    }
    else if(A.get(mid) < num){
      return binarySearch(A,mid+1,high,num);
    }
    else {
      return binarySearch(A,low,mid,num);
    }
  }

  public static int sumExist(List<Integer> A, int B){
    int n=A.size();
    for(int i=0;i<n;i++){
      for (int j=i+1;j<n;j++){
        if(Math.abs(A.get(i)-A.get(j)) == Math.abs(B)){
          return 1;
        }
      }
    }
    return 0;

  }

}
