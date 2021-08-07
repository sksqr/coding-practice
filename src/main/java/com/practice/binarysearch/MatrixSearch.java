package com.practice.binarysearch;

import java.util.ArrayList;

public class MatrixSearch {

  public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
    int row = A.size();
    int col = A.get(0).size();
    int rowToSearch = getRow(A,0,row,col,B);
    if(rowToSearch==-1){
      return 0;
    }
    if(binarySearch(A.get(rowToSearch),0,col,B)){
      return 1;
    }
    return 0;
  }

  private int getRow(ArrayList<ArrayList<Integer>> A, int low, int high, int col, int B){
    if(low>=high){
      return -1;
    }
    int mid = (low + high)/2;
    if(A.get(mid).get(0)<= B && B <= A.get(mid).get(col-1) ){
      return mid;
    }
    else if(A.get(mid).get(0) > B ){
      return getRow(A,low,mid,col,B);
    }
    else{
      return getRow(A,mid+1,high,col,B);
    }
  }

  private boolean binarySearch(ArrayList<Integer> A, int low, int high, int B){
    if(low>=high){
      return false;
    }
    int mid = (low + high)/2;
    if(A.get(mid) == B){
      return true;
    }
    else if(A.get(mid) > B){
      return binarySearch(A,low,mid,B);
    }
    else{
      return binarySearch(A,mid+1,high,B);
    }
  }
}
