package com.practice.facebook;

import java.util.Arrays;

public class Sum3Closest {

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    

    int[] nums = {0,1,-1,3};



    System.out.println(threeSumClosest(nums,1));
  }


  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n= nums.length;
    int dist=Integer.MAX_VALUE;
    int ans=0;
    for(int i=0; i<n-2; i++){
      int low=i+1;
      int high=n-1;
      while(low<high){
        int sum = nums[low]+nums[high]+nums[i];
        int dif = sum-target;
        if(Math.abs(dif)<dist){
          dist=Math.abs(dif);
          ans=sum;
        }
        if(sum>target){
          high--;
        }
        else if(sum<target){
          low++;
        }
        else{
          break;
        }
      }
    }
    return ans;
  }

}
