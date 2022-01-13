package com.practice.stack;

import java.util.List;

public class RainWaterTrapped {


  public int trap(final List<Integer> A) {
    int n = A.size();
    int[] leftMax= new int[n];
    int[] rightMax= new int[n];

    for(int i=0;i<n;i++){
      if(i==0){
        leftMax[i]=A.get(i);
      }
      else{
        leftMax[i] = Math.max(A.get(i),leftMax[i-1]);
      }
    }

    for(int i=n-1;i>=0;i--){
      if(i==n-1){
        rightMax[i]=A.get(i);
      }
      else{
        rightMax[i] = Math.max(A.get(i),rightMax[i+1]);
      }
    }

    int water =0;
    for(int i=0;i<n;i++){
      int ht = A.get(i);
      int min = Math.min(leftMax[i],rightMax[i]);
      if(min >ht){
        water += min - ht;
      }
    }
    return water;
  }

}
