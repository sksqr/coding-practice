package com.practice.subarray;
// Kaden's Algorithm
public class MaximumSumSubArrays {

  public static void main(String[] args) {
    int[] a ={1,1,0,1,1,0,0};
    int[] b ={-5,4,6,-3,4,-1};
    System.out.println("MaxSum :"+maxSumSubArray(b));
  }

  static  int maxSumSubArray(int[] a){
    int n = a.length;
    int currSum = 0;
    int maxSum = 0;

    for(int i=0; i<n; i++){
      currSum += a[i];

      if(currSum > maxSum){
        maxSum = currSum;
      }

      if(currSum < 0 ){
        currSum =0;
      }
    }
    return maxSum;
  }


}
