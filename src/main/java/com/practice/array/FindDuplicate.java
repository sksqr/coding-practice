package com.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(3, 4 ,1, 4, 1);
    List<Integer> A = Arrays.asList(3, 4 ,1, 4, 1);
    System.out.println(repeatedNumber(list));
  }
  public static int repeatedNumber(final List<Integer> A) {
    int n=A.size();
    Set<Integer> set = new HashSet<>();

    for(int i=0;i<n;i++){
      if(set.contains(A.get(i))){
        return A.get(i);
      }
      set.add(A.get(i));
    }
    return  -1;
  }

}
