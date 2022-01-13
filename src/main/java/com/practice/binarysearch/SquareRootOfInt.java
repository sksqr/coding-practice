package com.practice.binarysearch;

public class SquareRootOfInt {

  public static void main(String[] args) {
//    int a =2147483647;
    int a =17;
    System.out.println(sqrt(a));
  }

  public static int sqrt(int A) {
    if(A==0){
      return 0;
    }
    int low =1;
    int divisor = divisor(A);
    int high=A/divisor;
    return binarySearchForSqrt(low,high,A);
  }

  private static  int divisor(int A){
    int divisor=1;
    while (A>0){
      divisor=divisor*10;
      A=A/100;
    }
    return divisor/10;
  }
  private static int binarySearchForSqrt(int low, int high,int A){
    if(low>=high){
      if(A/low < low){
        return low-1;
      }
      return low;
    }
    int mid = low+ (high-low) /2;
    int sqr = A/mid;
    if(sqr == mid){
      return mid;
    }
    else if(sqr - mid < 0){
      return binarySearchForSqrt(low,mid-1,A);
    }
    else {
      return binarySearchForSqrt(mid+1,high,A);
    }
  }
}
