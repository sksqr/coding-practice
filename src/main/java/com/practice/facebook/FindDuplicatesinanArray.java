package com.practice.facebook;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesinanArray {

  public static void main(String[] args) {
    int[] nums = {1,1,2,2 };
    System.out.println(findDuplicates(nums));
  }



  public static List<Integer> findDuplicates(int[] nums) {
    int n=nums.length;
    List<Integer> result = new ArrayList();
    for(int i=0; i<n; i++){
      int index = nums[i];
      if(index>n){
        index = index%(n+1)-1;
      }
      else{
        index = index-1;
      }
      int val = nums[index];
      nums[index] = val + (n+1);
    }
    int twice = 2*(n+1);
    for(int i=0; i<n; i++){
      if(nums[i]>twice){
        result.add(i+1);
      }
    }
    return result;
  }

}
