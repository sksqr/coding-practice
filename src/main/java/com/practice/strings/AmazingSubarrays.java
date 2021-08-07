package com.practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazingSubarrays {

  public static void main(String[] args) {
    System.out.println(solve("ABEC"));
  }


  public static int solve(String A) {
    List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    Set<Character> amazingSet = new HashSet<>();
    amazingSet.addAll(list);
    int div = 10003;
    int n=A.length();
    int count=0;
    for(int i=0;i<n;i++){
      if(amazingSet.contains(A.charAt(i))){
        count += n-i;
      }
    }
    return count%div;
  }



}
