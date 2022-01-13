package com.practice.binarysearch;

import java.util.ArrayList;

public class SortedInsertPosition {

  public int searchInsert(ArrayList<Integer> a, int b) {
    return binarySearchPosition(a,b);
  }

  private int binarySearchPosition(ArrayList<Integer> a, int b){
    int l=0;
    int h=a.size()-1;
    int result=-1;
    while(l<=h){
      int mid = (l+h)/2;
      if(a.get(mid)==b){
        result = mid;
        break;
      }
      else if(a.get(mid)<b){
        l=mid+1;
      }
      else{
        h =mid-1;
      }
    }
    if(result==-1){
      result=l;
    }
    return result;
  }

}
