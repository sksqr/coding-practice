package com.practice.backtracking;

import java.util.Arrays;

public class MaximalString {



  public static void main(String[] args) {
    System.out.println(solve("129814999",4));
  }

  String max;

  public static String solve(String A, int B) {
//
//    char[] arr = A.toCharArray();
//    char[] res = maxString(arr,B,0);
//    return new String(res);

    MaximalString object = new MaximalString();
    object.max=A;
    object.solveWithHint(A,B);
    return object.max;
  }

  private void solveWithHint(String A, int B){
    if(B==0){
      return;
    }
    int n = A.length();
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        A = swap(A,i,j);
        if(A.compareTo(max)>0){
          max=A;
        }
        solveWithHint(A,B-1);
        A = swap(A,i,j);
      }
    }
  }

  private static String swap(String A, int i, int j){
    char[] arr = A.toCharArray();
    char temp= arr[i];
    arr[i]= arr[j];
    arr[j] =temp;
    String result = new String(arr);
    return result;
  }







  private static char[] maxStringB(char[] str, int B, int start){
    if(B==0 || start==str.length){
      return str;
    }
    int n = str.length;
    int maxIndex = start;
    char[] max = Arrays.copyOf(str,str.length);
    for(int i=start+1; i<n ;i++){
      char temp = str[i];
      str[i]=str[start];
      str[start] = temp;
      max = maxValue(max,str);
    }
    if(maxIndex==start){
      return maxString(str,B ,++start);
    }
    else {

      return maxString(str,--B ,++start);
    }
  }

  private static char[] maxValue (char[] a1, char[] a2){
    if(compare(a1,a2) >=0){
      return a1;
    }
    return a2;
  }

  private static int compare(char[] a1, char[] a2){
    for(int i=0;i<a1.length;i++){
      int diff = a1[i]-a2[i];
      if(diff !=0 ){
        return diff;
      }
    }
    return 0;
  }


  private static char[] maxString(char[] str, int B, int start){
    if(B==0 || start==str.length){
      return str;
    }
    int n = str.length;
    int maxIndex = start;
    for(int i=start; i<n ;i++){
      if(str[i] > str[maxIndex] || (maxIndex!=start && str[i] >= str[maxIndex] )){
        maxIndex = i;
      }
    }
    if(maxIndex==start){
      return maxString(str,B ,++start);
    }
    else {
      char temp = str[maxIndex];
      str[maxIndex]=str[start];
      str[start] = temp;
      return maxString(str,--B ,++start);
    }
  }


}
