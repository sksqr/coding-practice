package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

  public int solve(ArrayList<Integer> A) {
    Map<Integer,Integer> map = new HashMap();
    int n=A.size();
    int indexOfFirstRepeating = n;
    for(int i=0;i<n;i++){
      if(map.get(A.get(i))==null){
        map.put(A.get(i),i);
      }
      else{
        int index = map.get(A.get(i));
        if(index < indexOfFirstRepeating){
          indexOfFirstRepeating = index;
        }
      }
    }
    if(indexOfFirstRepeating == n){
      return -1;
    }
    return A.get(indexOfFirstRepeating);
  }
}
