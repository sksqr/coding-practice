package com.practice.binarysearch;

import java.util.Arrays;
import java.util.List;

public class CountElementOccurence {

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(4, 7, 7, 7, 8, 10, 10);
    System.out.println(findCount(A,3));
  }

  public static int findCount(final List<Integer> A, int B) {
    int index = binarySearch(A,0,A.size(),B) ;
    if(index==-1){
      return 0;
    }
    int count =1;
    int i=index-1;
    while(i>=0 && A.get(i)==B){
      count++;
      i--;
    }
    i=index+1;
    while(i<A.size() && A.get(i)==B){
      count++;
      i++;
    }
    return count;
  }
  private static int binarySearch(final List<Integer> A, int low, int high, int value){
    if(low>=high){
      return -1;
    }
    int mid = (low + high)/2;
    int ele = A.get(mid);
    if(ele == value){
      return mid;
    }
    if(ele > value){
      return binarySearch(A,low,mid,value);
    }
    else{
      return binarySearch(A,mid+1,high,value);
    }
  }

}
