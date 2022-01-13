package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfTwo {

  public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
    int n = A.size();
    Map<Integer,Integer> map = new HashMap();
    ArrayList<Integer> result = new ArrayList();
    int first=0;
    for(int i=0; i<n;i++){
      if(map.get(B-A.get(i))!=null){
        first = map.get(B-A.get(i));
        result.add(first);
        result.add(i+1);
        return result;
      }
      if(map.get(A.get(i))==null){
        map.put(A.get(i),i+1);
      }
    }
    return result;
  }

}
