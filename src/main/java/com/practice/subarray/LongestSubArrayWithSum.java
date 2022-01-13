package com.practice.subarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum {

  static void printLongestSubArrayWithSum(int[] a, int sum){
    int n=a.length;

    Map<Integer, Integer> map = new HashMap<>();
    int currentSum=0;
    int start = 0;
    int end = -1;
    for(int i=0;i<n;i++){
      currentSum+=a[i];

      if(currentSum == sum){
        start =0;
        end =i;
      }

      int diff  = currentSum-sum;
      if(map.get(diff)!=null){
        start = map.get(diff)+1;
        end = i;
      }
      if(map.get(currentSum)==null){
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

  public static void main(String[] args) {
    int[] a = {1,1,10,15,-5,15,-10,5};
    printLongestSubArrayWithSum(a,2);
  }

}
