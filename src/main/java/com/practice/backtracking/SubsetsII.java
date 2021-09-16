package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4, 2, 2, 2, 7, 7, 5, 8, 7, 1);
    SubsetsII subsetsII = new SubsetsII();
    System.out.println(subsetsII.subsetsWithDup(new ArrayList<>(list)));
  }



  public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> subSets= subSets(A,0);
    Set<String> set = new HashSet<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for(ArrayList<Integer> list : subSets){
      Collections.sort(list);
      if(!set.contains(list.toString())){
        set.add(list.toString());
        result.add(list);
      }
    }
    Collections.sort(result,(l1,l2)->{
      if(l1.size()==0 && l2.size()==0){
        return 0;
      }
      if(l1.size()==0){
        return -1;
      }
      if(l2.size()==0){
        return 1;
      }
      int i=0;
      while (i<l1.size() && i<l2.size()){
        if(l1.get(i) != l2.get(i)){
          return l1.get(i) - l2.get(i);
        }
        i++;
      }
      return l1.size()-l2.size();
    });
    return result;
  }



  private ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> A, int i){
    if(i==A.size()){
      ArrayList<ArrayList<Integer>> result= new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }
    ArrayList<ArrayList<Integer>> withOut = subSets(A,i+1);
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for(ArrayList<Integer> list: withOut){
      ArrayList<Integer> listWith = new ArrayList<>();
      listWith.add(A.get(i));
      listWith.addAll(list);
      result.add(listWith);
    }
    result.addAll(withOut);
    return result;
  }

}
