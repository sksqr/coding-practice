package com.practice.strings;

public class MinimumAppendsForPalindrome {

  public static void main(String[] args) {
    MinimumAppendsForPalindrome obj = new MinimumAppendsForPalindrome();
    System.out.println(obj.solve("abcc"));
  }


  public int solve(String A) {
    int n = A.length();
    char[] arr = A.toCharArray();
    int i;
    for( i=0;i<n;i++){
      if(isPalindrome(arr,i,n-1)){
        return i;
      }
    }
    return i;
  }

  boolean isPalindrome(char[] A, int start, int end){

    while(start<end){
      if(A[start]!=A[end]){
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
