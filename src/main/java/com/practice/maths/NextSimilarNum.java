package com.practice.maths;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NextSimilarNum {

  public static void main(String[] args) {
//    System.out.println(solve("218765"));
//    System.out.println(solve("4321"));
//    System.out.println(solve("551"));
//    System.out.println(solve("1152"));
    System.out.println(solve("892795"));
  }



  public static String solve(String A) {
    int n=A.length();
    int i=n-2;

    while(i>=0 && A.charAt(i)>=A.charAt(i+1)){
      i--;
    }
    int index = i;
    if(i<0){
      return "-1";
    }
    int value = A.charAt(i);
    int min = Integer.MAX_VALUE;
    int swapIndex=-1;
    i++;
    while(i<n){
      if(A.charAt(i) > value && A.charAt(i) < min ){
        min = A.charAt(i);
        swapIndex = i;
      }
      i++;
    }
    char[] arr = A.toCharArray();
    if(swapIndex!=-1){
      char temp = arr[swapIndex];
      int j=swapIndex-1;
      while (j>=index){
        arr[j+1]=arr[j];
        j--;
      }
      arr[index]=temp;
    }
    StringBuilder sb = new StringBuilder();
    for(int k=0;k<=index;k++){
      sb.append(arr[k]);
    }
    List<Character> list = new ArrayList<>();
    for(int j=index+1;j<n;j++){
      list.add(arr[j]);
    }
    Collections.sort(list);
    for(Character c:list){
      sb.append(c);
    }
    return sb.toString();
  }

}
