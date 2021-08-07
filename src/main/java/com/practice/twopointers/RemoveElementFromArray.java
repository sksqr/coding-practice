package com.practice.twopointers;

/*
Given an array and a value, remove all the instances of that value in the array.

Also return the number of elements left in the array after the operation.

It does not matter what is left beyond the expected length.

Example:

If array A is [4, 1, 1, 2, 1, 3]

and value elem is 1,

then new length is 3, and A is now [4, 2, 3]

Try to do it in less than linear additional space complexity.
 */

import java.util.ArrayList;
import java.util.List;

public class RemoveElementFromArray {

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();;
    a.add(0); a.add(1); a.add(0); a.add(2); a.add(1); a.add(1); a.add(1);
    Integer i = new Integer(1);
    List<Integer> ls = new ArrayList<>();
    ls.add(i);
    a.removeAll(ls);
    System.out.println(a);

  }


    public static int removeElement(ArrayList<Integer> a, int b) {
      int n= a.size();
      int j=0;
      int i=0;
      while (i<n && j<n){
        while (i<n && a.get(i)!=b){
          i++;
        }
        if(i==n){
          return a.size();
        }
        j=i+1;
        while (j<n && a.get(j)==b){
          j++;
        }
        if(j<n && i<j) {
          swap(a,i,j);
          i++;
          j++;
        }
      }
      i = a.size()-1;
      while (i>=0 && i< a.size() &&a.get(i)==b){
        a.remove(i);
        i=a.size()-1;
      }
      System.out.println(a);
      return a.size();
    }

  public static int removeElement1(ArrayList<Integer> a, int b) {
    int n= a.size();
    int j=0;
    for (int i=0; j<n;  j++){
      if(a.get(i) == b){
       a.remove(i);
      }
      else {
        i++;
      }
    }
    System.out.println(a);
    return a.size();
  }


  private static void swap(ArrayList<Integer> a, int i, int j){
    Integer temp = a.get(i);
    a.set(i,a.get(j));
    a.set(j,temp);
  }

}
