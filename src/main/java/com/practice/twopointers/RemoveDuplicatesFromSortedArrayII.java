package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArrayII {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
    List<Integer> list = Arrays.asList(1,1,1,1,2,2,2,2,3,3,3);
    ArrayList<Integer> aar = new ArrayList<>();
    aar.addAll(list);
    System.out.println(obj.removeDuplicates2(aar));
    System.out.println(aar);
  }

  public int removeDuplicates(ArrayList<Integer> a) {
    int prev=a.get(0);
    int n=a.size();
    int count=1;
    for(int i=1;i<a.size();i++){
      if(prev==a.get(i)){
        count++;
      }
      else{
        prev=a.get(i);
        count=1;
      }
      if(count>2){
        while(i<a.size() && a.get(i).equals(prev)){
          a.remove(i);
        }
        if(i<a.size()){
          prev=a.get(i);
          count=1;
        }
      }
    }
    return a.size();
  }


  public int removeDuplicates2(ArrayList<Integer> a) {
    ArrayList<Integer> temp = new ArrayList<>();
    int prev=a.get(0);
    int n=a.size();
    int count=1;
    temp.add(prev);
    for(int i=1;i<a.size();i++){
      if(prev==a.get(i)){
        count++;
        if(count<=2){
          temp.add(a.get(i));
        }
      }
      else {
        prev=a.get(i);
        count=1;
        temp.add(a.get(i));
      }
      if(count>2){
        while(i<a.size() && a.get(i).equals(prev)){
          i++;
        }
        if(i<a.size()){
          prev=a.get(i);
          count=1;
          temp.add(a.get(i));
        }
      }
    }
    a.clear();;
    a.addAll(temp);
    return a.size();
  }



}
