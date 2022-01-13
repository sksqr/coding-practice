package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum4 {

  public static void main(String[] args) {
    Sum4 sum4 = new Sum4();
    List<Integer> list = Arrays.asList(1 ,0, -1, 0, -2, 2);
    int B=0;
    System.out.println(sum4.fourSum(new ArrayList<>(list),B));

  }

  public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
    ArrayList<ArrayList<Integer>> result = fourSumStatic(A,B);
    Collections.sort(result,(l1,l2)-> {
      int i=0;
      while (i<l1.size() && l1.get(i)==l2.get(i)){
        i++;
      }
      if(i<l1.size()){
        return l1.get(i)-l2.get(i);
      }
      return 0;
    });
    return result;
  }


  public static ArrayList<ArrayList<Integer>> fourSumStatic(ArrayList<Integer> A, int B) {
    Map<Integer,List<List<Integer>>> map = new HashMap<>();
    Set<String> stringSet = new HashSet<>();
    ArrayList<ArrayList<Integer>> result= new ArrayList<>();
    int n=A.size();
    for(int i=0; i<n; i++ ){
      for(int j=i+1; j<n; j++){
        int sum = A.get(i) + A.get(j);
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        if(map.get(sum)==null){
          map.put(sum,new ArrayList<>());
        }
        map.get(sum).add(list);
      }
    }

    for(Integer key : map.keySet()){
      if(map.containsKey(B-key)){
        List<List<Integer>> listList1 = map.get(key);
        List<List<Integer>> listList2 = map.get(B-key);
        for(int k=0; k<listList1.size();k++){
          for(int k2=0;k2<listList2.size();k2++){
            Set<Integer> set = new LinkedHashSet<>();
            set.addAll(listList1.get(k));
            set.addAll(listList2.get(k2));
            if(set.size()==4){
              ArrayList<Integer> subList = new ArrayList<>();
              for(Integer index : set){
                subList.add(A.get(index));
              }
              Collections.sort(subList);
              String str = subList.toString();
              if(!stringSet.contains(str)){
                result.add(subList);
                stringSet.add(str);
              }

            }
          }
        }
      }
    }
    return result;
  }

}
