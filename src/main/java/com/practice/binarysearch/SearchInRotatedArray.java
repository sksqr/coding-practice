package com.practice.binarysearch;

import java.util.Arrays;
import java.util.List;

public class SearchInRotatedArray {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4, 5, 6, 7, 0, 1, 2 );
    System.out.println(search(list,0));
  }

  public static int search(final List<Integer> A, int B) {
    return binarySearchInRotated(0,A.size(),B,A);
  }

  private static int binarySearchInRotated(int low, int high, int B,final List<Integer> A )
  {
    if(low>=high){
      return -1;
    }
    int mid = low + (high -low)/2;
    if(A.get(mid) == B){
      return mid;
    }
    if(A.get(low) < A.get(mid)){
      if(A.get(low) <= B && B < A.get(mid)){
        return binarySearch(low,mid,B,A);
      }
      else{
        return binarySearchInRotated(mid+1,high,B,A);
      }
    }
    else if(A.get(high-1) > A.get(mid)){
      if( A.get(mid) < B && B <= A.get(high-1)){
        return binarySearch(mid+1,high,B,A);
      }
      else{
        return binarySearchInRotated(low,mid,B,A);
      }

    }
    return -1;
  }

  private static int binarySearch(int low, int high, int B,final List<Integer> A )
  {
    if(low>=high){
      return -1;
    }
    int mid = low + (high -low)/2;
    if(A.get(mid) == B){
      return mid;
    }
    if( B < A.get(mid)){
      return binarySearch(low,mid,B,A);
    }
    else {
      return binarySearch(mid+1,high,B,A);
    }
  }

}
