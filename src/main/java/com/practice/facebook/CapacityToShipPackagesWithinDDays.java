package com.practice.facebook;

public class CapacityToShipPackagesWithinDDays {

  public int solve(int[] A, int B) {
    int n = A.length;
    int max=0;
    int sum=0;
    for(int i=0; i<n; i++){
      if(max<A[i]){
        max=A[i];
      }
      sum += A[i];
    }
    int low=max;
    int high=sum;
    return minCap(A,B,low,high);
  }

  private int minCap(int[] A, int B, int low, int high){
    int mid = low + (high-low)/2;
    boolean mid_1 = valid(A,mid-1,B);
    boolean midValid = valid(A,mid,B);
    if(!mid_1 && midValid){
      return mid;
    }
    else if(mid_1 && midValid){
      return minCap(A,B,low,mid-1);
    }
    else{
      return minCap(A,B,mid+1,high);
    }

  }

  private boolean valid(int[] A, int cap, int B){
    int n=A.length;
    int i=0;
    int dCap=cap;
    while(B>0 && i<n){
      while(i<n && dCap-A[i]>=0){
        dCap = dCap-A[i];
        i++;
      }
      B--;
      dCap=cap;
    }
    if(i==n){
      return true;
    }
    return false;
  }

}
