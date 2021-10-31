package com.practice.array;

import java.util.HashMap;
import java.util.Map;

/*
Given two arrays A and B of length N,
 determine if there is a way to make A equal to B by reversing any subarrays from array B
 any number of times.

Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true

After reversing the subarray of B from indices 1 to 3, array B will equal array A.

 */
public class ReversetoMakeEqual {


  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here

    int n1=array_a.length;
    int n2=array_b.length;
    if(n1!=n2){
      return false;
    }
    Map<Integer,Integer> map1 = new HashMap();
    Map<Integer,Integer> map2 = new HashMap();

    for(int i=0;i<n1;i++){
      if(map1.get(array_a[i]) == null){
        map1.put(array_a[i],0);
      }
      map1.put(array_a[i],map1.get(array_a[i])+1);

      if(map2.get(array_b[i]) == null){
        map2.put(array_b[i],0);
      }
      map2.put(array_b[i],map2.get(array_b[i])+1);
    }

    for(Integer key: map1.keySet()){
      if(map1.get(key)!=map2.get(key)){
        return false;
      }
    }
    return true;
  }


}
