package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {

  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    Set<String> set = new HashSet();
    ArrayList<ArrayList<Integer>> resultTemp = combinationSumRec(A,B,0);
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    for(int i=0; i< resultTemp.size(); i++){
      String key = resultTemp.get(i).toString();
      if(!set.contains(key)){
        result.add(resultTemp.get(i));
        set.add(key);
      }
    }
    return result;
  }

  public ArrayList<ArrayList<Integer>> combinationSumRec(ArrayList<Integer> A, int B, int index) {
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    if(B==0){
      result.add(new ArrayList());
      return result;
    }
    if(index==A.size()){
      return result;
    }

    if(A.get(index)<=B){
      ArrayList<ArrayList<Integer>> includedRepeat = combinationSumRec(A, B-A.get(index), index);
      ArrayList<ArrayList<Integer>> includedNonRepeat = combinationSumRec(A, B-A.get(index), index+1);
      for(int i=0;i<includedRepeat.size();i++){
        ArrayList<Integer> list = new ArrayList();
        list.add(A.get(index));
        list.addAll(includedRepeat.get(i));
        result.add(list);
      }
      for(int i=0;i<includedNonRepeat.size();i++){
        ArrayList<Integer> list = new ArrayList();
        list.add(A.get(index));
        list.addAll(includedNonRepeat.get(i));
        result.add(list);
      }
    }
    ArrayList<ArrayList<Integer>> excluded = combinationSumRec(A, B, index+1);
    result.addAll(excluded);
    return result;
  }


}
