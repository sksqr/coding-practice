/*
Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
 */


package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Subset {


  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> result = subsetsRec(A,0);
    Collections.sort(result, (l1,l2)->{
     if(l1.size()==0 && l2.size()==0){
       return 0;
     }
     if(l1.size()==0 || l2.size()==0){
       return l1.size()-l2.size();
     }
     int i=0;
     while (i>l1.size() && i<l2.size()){
       if(l1.get(i)!=l2.get(i)){
         return  l1.get(i)-l2.get(i);
       }
     }
     return l1.size()-l2.size();
    });
    return result;
  }

  private ArrayList<ArrayList<Integer>> subsetsRec(ArrayList<Integer> A, int index){
    if(index>=A.size()){
      ArrayList<ArrayList<Integer>> result = new ArrayList();
      result.add(new ArrayList());
      return result;
    }
    ArrayList<ArrayList<Integer>> withOutI = subsetsRec(A, index+1);
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    result.addAll(withOutI);
    for(int i=0;i<withOutI.size();i++){
      ArrayList<Integer> withI = new ArrayList();
      withI.add(A.get(index));
      withI.addAll(withOutI.get(i));
      result.add(withI);
    }
    return result;
  }

}
