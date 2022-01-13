package com.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

  public static void main(String[] args) {

    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
    String s1="ABCDGH" ;
    String s2="ACDGHR";


    System.out.println(LCSIterative( s1 ,s2));
    System.out.println("Done");

  }



  static Map<String, Integer> map2 = new HashMap<>();


  private static int LCSIterative(String s1, String s2){
    int[][] map = new int[s1.length()+1][s2.length()+1];
    for(int i=0;i<=s1.length();i++){
      map[i][0]=0;
    }
    for(int i=0;i<=s2.length();i++){
      map[0][i]=0;
    }

    for(int i=1;i<=s1.length();i++){
      for(int j=1;j<=s2.length();j++){
          if(s1.charAt(i-1)==s2.charAt(j-1)){
            map[i][j]=1+map[i-1][j-1];
          }
          else {
            map[i][j] = Math.max(map[i-1][j],map[i][j-1]);
          }
        }
    }

//    for(int i=0;i<=s1.length();i++){
//      System.out.println(i+":");
//      for(int j=0;j<=s2.length();j++){
//        System.out.print(map[i][j]+" ");
//      }
//    }
    return map[s1.length()][s2.length()];
  }

  private int LCS(String s1, String s2, int i, int  j){
    if(i==s1.length() || j==s2.length()){
      return 0;
    }
    String key = i+":"+j;
    if(map2.get(key)!=null){
      return map2.get(key);
    }
    int value1=0;
    int value2=0;
    if(s1.charAt(i) == s2.charAt(j)){
      value1 = 1 + LCS(s1,s2,i+1,j+1);
    }
    else {
      value1 = LCS(s1,s2,i+1,j+1);
    }
    value2 = Math.max(LCS(s1,s2,i,j+1),LCS(s1,s2,i+1,j));

    int value = Math.max(value1,value2);
    map2.put(key,value);
    return value;
  }

}
