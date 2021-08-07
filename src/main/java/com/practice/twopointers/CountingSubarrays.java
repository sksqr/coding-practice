package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountingSubarrays {

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3, 4, 4, 5, 2, 2, 4, 9, 8, 5);
    System.out.println(solve(A,32));
  }

  public static int solve(List<Integer> A, int B) {
    List<Integer> preFixSum = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int sum=0;
    int count=0;
    preFixSum.add(0);
    for(int i=0;i<A.size();i++){
//      if(A.get(i) < B && !set.contains(A.get(i))){
//        count++;
//        set.add(A.get(i));
//      }
      sum += A.get(i);
      preFixSum.add(sum);
    }
    int n=A.size();

    for(int i=0;i<n;i++){
      for(int j=i+1;j<n+1;j++){
        if(preFixSum.get(j) - preFixSum.get(i) < B){
          count++;
        }
      }
    }
    return count;
  }


  public static int solveWithTwoPointers(List<Integer> A, int B) {
   return 0;
  }

}
