package com.practice.subarray;

import java.util.HashMap;
import java.util.Map;

public class LogestSubArrayWithEqual0And1 {

  public static void main(String[] args) {
    int[] a ={1,1,0,1,1,0,0};
    int[] b ={1,1,0,0,0,0,0};
    logestSubArray(b);
  }

  static void logestSubArray(int[] a){

    int n=a.length;

    int start = 0;
    int end = -1;
    int currentSum=0;

    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<n; i++){

      currentSum += a[i]==0?-1:a[i];

      if(currentSum == 0){
        start=0;
        end=i;
      }

      if(map.containsKey(currentSum)){
        start = map.get(currentSum)+1;
        end = i;
      }

      if(!map.containsKey(currentSum)){
        map.put(currentSum,i);
      }

    }

    if(end != -1){
      System.out.println("Start:"+start+" End:"+end);
    }
    else {
      System.out.println("Not Found");
    }

  }

}
