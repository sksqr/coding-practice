package com.practice.facebook;

public class BitonicSearch {

  public static void main(String[] args) {
//    int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
//    int B =12;
    int[] A ={ 1, 20, 50, 40, 10};
    int B=5;
    BitonicSearch obj = new BitonicSearch();
    System.out.println(obj.solve(A,B));
  }

  public int solve(int[] A, int B) {
    int point = flexPoint(A,0,A.length-1);
    System.out.println("point:"+point);
    if(point==-1){
      return -1;
    }

      int r1 = binarySearchInc(A,0,point,B);
    if(r1==-1){
      r1 = binarySearchDec(A,point+1,A.length-1,B);
    }
    return r1;
  }

  private int flexPoint(int[] A,int low, int high){
    if(low>high){
      return -1;
    }
    int mid = low +(high-low)/2;
    if(A[mid]>A[mid+1] && A[mid]>A[mid-1]){
      return mid;
    }
    if(A[mid]>A[low]){
      return flexPoint(A,mid+1,high);
    }
    else{
      return flexPoint(A,low,mid-1);
    }
  }

  private int binarySearchDec(int[] A,int low, int high, int B){
    if(low>high){
      return -1;
    }
    int mid = low +(high-low)/2;
    if(A[mid]==B){
      return mid;
    }
    if(A[mid]>B){
      return  binarySearchDec(A,mid+1,high,B);
    }
    else{
      return  binarySearchDec(A,low,mid-1,B);
    }
  }

  private int binarySearchInc(int[] A,int low, int high, int B){
    if(low>high){
      return -1;
    }
    int mid = low +(high-low)/2;
    if(A[mid]==B){
      return mid;
    }
    if(A[mid]>B){
      return  binarySearchInc(A,low,mid-1,B);
    }
    else{
      return  binarySearchInc(A,mid+1,high,B);
    }
  }


}
