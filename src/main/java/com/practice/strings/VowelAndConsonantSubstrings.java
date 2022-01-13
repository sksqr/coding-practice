package com.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class VowelAndConsonantSubstrings {

  public int solve(String A) {
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('o');
    vowels.add('u');
    vowels.add('i');

    int total=0;
    int n = A.length();
    int i = n-1;
    int cCount=0;
    int vCount=0;
    int mod = 1000000007;
    while(i>=0){

      if(vowels.contains(A.charAt(i))){
        total = (total + cCount)%mod;
        vCount++;
      }
      else{
        cCount++;
        total = (total + vCount)%mod;
      }
      i--;
    }
    return total;
  }

}
