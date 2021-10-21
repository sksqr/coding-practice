package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3Zero {

  public static void main(String[] args) {
    Sum3Zero sum3Zero =  new Sum3Zero();
    List<Integer> list = Arrays.asList(2147483647, -2147483648, -2147483648, 0, 1);
    ArrayList<ArrayList<Integer>> result = sum3Zero.threeSum(new ArrayList<>(list));
    System.out.println(result);
  }


  public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
    Collections.sort(A);
    Set<String> set = new HashSet();
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    int n = A.size();
    for(int i=0;i<n; i++){
      long a = A.get(i);
      int s = i+1;
      int e = n-1;
      while(s<e){
        long b = A.get(s);
        long c = A.get(e);
        long sum = a+b+c;
        if(sum==0){
          ArrayList<Integer> list = new ArrayList();
          list.add((int) a);
          list.add((int) b);
          list.add((int) c);
          String key = list.toString();
          if(!set.contains(key)){
            result.add(list);
            set.add(key);
          }
          s++;
          e--;
        }
        else if(sum < 0){
          s++;
        }
        else{
          e--;
        }

      }
    }
    Collections.sort(result, (l1,l2)->{
      for(int i=0; i<l1.size(); i++){
        if(l1.get(i)!= l2.get(i)){
          return l1.get(i) - l2.get(i);
        }
      }
      return 0;
    });
    return result;
  }

}
