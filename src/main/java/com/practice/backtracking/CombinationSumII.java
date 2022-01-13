package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

  public static void main(String[] args) {
    CombinationSumII combinationSumII = new CombinationSumII();
    List<Integer> list = Arrays.asList(10,1,2,7,6,1,5);
    int target=8;
    System.out.println(combinationSumII.combinationSum(new ArrayList<>(list), target));
  }

  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    Collections.sort(a, Comparator.reverseOrder());
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<ArrayList<Integer>> tmpResult = combinationSumRec(a,b,0);
    Collections.sort(tmpResult,(l1,l2)->{
      int i=0;
      while(i<l1.size() && i<l2.size()){
        int diff  = l1.get(i)-l2.get(i);
        if(diff!=0){
          return diff;
        }
        i++;
      }
      return l1.size()-l2.size();

    });

    Set<String> set = new HashSet<>();
    for(ArrayList<Integer> list : tmpResult){
      String key = list.toString();
      if(!set.contains(key)){
        result.add(list);
        set.add(key);
      }
    }
    return result;
    }

  public ArrayList<ArrayList<Integer>> combinationSumRec(ArrayList<Integer> a, int b, int index) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if(b==0){
      result.add(new ArrayList<>());
      return result;
    }
    if(index==a.size()){
      return  result;
    }
    int num = a.get(index);
    if(b-num>=0) {
      ArrayList<ArrayList<Integer>> subResult1 = combinationSumRec(a,b-num,index+1);
      for(ArrayList<Integer> list : subResult1) {
        list.add(num);
      }
      result = subResult1;
    }
    ArrayList<ArrayList<Integer>> subResult2 = combinationSumRec(a,b,index+1);
    result.addAll(subResult2);
    return result;
  }

}
