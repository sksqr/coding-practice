package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickFromBothSide {

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(5, -2, 3 , 1, 2);
    List<Integer> B = Arrays.asList( 511, -798, -366, -728, -945, -672, -354, -638, -114, -125, -567, 869, -858, 844, 416, 881, 998, -678, -349, -979, 699, 557, -524, 892, -611, 75, -288, -400, -490, 3, -131, 861, -312, 401, 789, 255, -577, 2, -415, -818, -715, 88, 426, -383, 757, 832, -68, -831, -846, 721, 189, 976, 329, -632, -308, 425, -445, 434, -451, 441, 512, -855, -940, 718, 753, -861, -577, -721, 996, -313, -471, -451, 437, 866, -51, -807);
    System.out.println(solve(B,16));
  }

  public static int solveWithOutSpace(List<Integer> A, int B) {
    return 0;
  }


  public static int solve(List<Integer> A, int B) {
    int n= A.size();
    List<Integer> list = new ArrayList();
    for(int i=n-B; i<n; i++){
      list.add(A.get(i));
    }
    for(int i=0; i<B; i++){
      list.add(A.get(i));
    }
    int i=0;
    int sum=0;
    while(i<B)    {
      sum+=list.get(i);
      i++;
    }
    int start=0;
    int end=i;
    int maxSum = sum;
    while(end < list.size()){
      sum-=list.get(start);
      start++;
      sum+=list.get(end);
      end++;
      if(sum > maxSum){
        maxSum = sum;
      }
    }
    return maxSum;
  }


}
