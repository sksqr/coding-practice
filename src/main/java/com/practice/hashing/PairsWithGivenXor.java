package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXor {

  public static void main(String[] args) {
//    int a=5;
//    int b=7;
//    int xor = a^b;
//    System.out.println("xor:"+xor);
//    int xor_a = xor^a;
//    System.out.println("xor^a:"+xor_a);


  }


  public int solve(ArrayList<Integer> A, int B) {
    Set<Integer> set = new HashSet();
    int n=A.size();
    for(int i=0;i<n;i++){
      set.add(A.get(i));
    }
    int count=0;
    for(int i=0;i<n;i++){
      int xor_i = B^A.get(i);
      if(set.contains(xor_i)){
        count++;
      }
    }
    return count/2;
  }
}
