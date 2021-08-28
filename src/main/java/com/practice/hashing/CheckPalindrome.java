package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {

  public int solve(String A) {
    Map<Character,Integer> map = new HashMap();
    int  n= A.length();
    for(int i=0; i<n; i++){
      if(map.get(A.charAt(i))==null){
        map.put(A.charAt(i),0);
      }
      map.put(A.charAt(i),map.get(A.charAt(i))+1);
    }
    int oddCount=0;
    for(Character c: map.keySet()){
      if(map.get(c)%2 != 0){
        oddCount++;
      }
    }

    if(n%2==0 && oddCount==0){
      return 1;
    }
    if(n%2!=0 && oddCount==1){
      return 1;
    }
    return 0;
  }

}
