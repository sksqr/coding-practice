package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Combinations {

  public static void main(String[] args) {
    int A=4;
    int B=2;
    ArrayList<ArrayList<Integer>> lists = combination(A,B);
    lists.sort((l1,l2)->{
      for(int i=0;i<l1.size();i++){
        if(l1.get(i)!=l2.get(i)){
          return l1.get(i) - l2.get(i);
        }
      }
      return 0;
    });
    System.out.println(lists);;
  }


  public static ArrayList<ArrayList<Integer>> combination(final int A, int B) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if(A==0){
      return result;
    }
    if(B==1){
      for(int i=1;i<=A;i++){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        result.add(list);
      }
      return result;
    }
    ArrayList<ArrayList<Integer>> withoutA = combination(A-1, B);
    ArrayList<ArrayList<Integer>> withA = combination(A-1, B-1);
    result.addAll(withoutA);
    withA.forEach(e-> e.add(A));
    result.addAll(withA);
    return result;
  }

}
