package com.practice.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

  public int majorityElement(final List<Integer> A) {
    int n= A.size();

    Map<Integer,Integer> countMap = new HashMap();
    int maxCount=0;
    int majorityElement=A.get(0);
    for(int i=0; i<n; i++){
      if(countMap.get(A.get(i))==null){
        countMap.put(A.get(i),0);
      }
      int count = countMap.get(A.get(i))+1;
      countMap.put(A.get(i),count);
      if(count>maxCount){
        maxCount = count;
        majorityElement = A.get(i);
      }
    }
    return majorityElement;
  }

}
