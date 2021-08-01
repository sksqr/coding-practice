package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NobleInteger {

  public static void main(String[] args) {
  List<Integer> list = Arrays.asList(  -4, -2, 0, -1, -6);
  System.out.println(solve(list));
  }

  public static int solve(List<Integer> A) {
    Collections.sort(A, (i1,i2) ->  i2-i1);
    System.out.println(A);
    int lastGreaterNo = Integer.MIN_VALUE;
    for(int i=0; i<A.size();i++){
      if(A.get(i) == i && A.get(i) != lastGreaterNo){
        return 1;
      }
      lastGreaterNo = A.get(i);
    }
    return -1;
  }



}
