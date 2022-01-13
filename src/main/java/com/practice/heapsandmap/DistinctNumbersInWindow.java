package com.practice.heapsandmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {

  public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
    Map<Integer,Integer> map = new HashMap();
    int n=A.size();
    int i;
    for(i=0; i<B; i++){
      map.put(A.get(i),i);
    }
    ArrayList<Integer> result = new ArrayList();
    result.add(map.keySet().size());
    int k=0;
    while(i<n){
      if(map.get(A.get(k)) == k){
        map.remove(A.get(k));
      }
      map.put(A.get(i),i);
      result.add(map.keySet().size());
      i++;
      k++;
    }
    return result;
  }

}
