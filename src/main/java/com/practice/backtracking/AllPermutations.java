package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPermutations {

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println(permute(list));
  }

  public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    int n = A.size();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if(n==1){
      result.add(A);
      return result;
    }

    for(int i=0;i<n;i++){
      int num = A.get(i);
      ArrayList<Integer> B = new ArrayList<>();
      B.addAll(A);
      B.remove(i);
      ArrayList<ArrayList<Integer>> subResult = permute(B);
      for(int j=0;j<subResult.size();j++){
        ArrayList<Integer> list = new ArrayList<>();;
        list.add(A.get(i));
        list.addAll(subResult.get(j));
        result.add(list);
      }
    }
    return result;
  }

}
