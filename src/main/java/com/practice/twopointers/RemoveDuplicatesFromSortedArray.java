package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 );
    ArrayList<Integer> a = new ArrayList<>();;
    a.add(0); a.add(0); a.add(0); a.add(1); a.add(1); a.add(2); a.add(2);
//    a.add(0);
    removeDuplicates(a);
  }


  public static int removeDuplicatesEf(ArrayList<Integer> a) {
    Set<Integer> set = new LinkedHashSet<>();
    set.addAll(a);
    a.clear();
    a.addAll(set);
    return a.size();
  }


  public static int removeDuplicates(ArrayList<Integer> a) {
    int n=a.size();
    int prev=a.get(0);
    for(int i=1;i<n;i++){
      if(a.get(i)==prev){
        a.set(i,null);
      }
      else {
        prev=a.get(i);
      }
    }

    int i=0;
    int j=0;
    while(j<n && i<n ){
      if(a.get(j)!=null){
        swap(a,i,j);
        i++; j++;
      }
      else {
        j++;
      }
    }
     i=n-1;
    while (i>=0 && a.get(i)==null){
      a.remove(i);
      i--;
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
