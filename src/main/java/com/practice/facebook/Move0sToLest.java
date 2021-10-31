package com.practice.facebook;
/*
1,2,3,4,0,5,0,6,0

Given an integer array, move all elements that are 0 to the left
 while maintaining the order of other elements in the array.
 The array has to be modified in-place.
 */

public class Move0sToLest {


  public static void main(String[] args) {
    int[] a= {1,2,3,4,0,5,0,6,0};
    moveZerosToLeft(a);
    System.out.println(a);
  }

  public static void moveZerosToLeft(int[] a){
    int n =a.length;
    int lastZero=n-1;
    int lastNonZero=n-1;

    while (lastNonZero>=0 && lastZero>=0){

      while (lastNonZero>=0 && a[lastNonZero]==0){
        lastNonZero--;
      }

      while (lastZero>=0 && a[lastZero]!=0){
        lastZero--;
      }

      if(lastNonZero>=0 && lastZero>=0){

        int i=lastNonZero;
        int j=lastZero;
        //swap
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
      }

    }
  }

}
