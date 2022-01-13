package com.practice.strings;

public class MinimumCharactersRequiredToMakeAStringPalindromic {

  public static void main(String[] args) {
    MinimumCharactersRequiredToMakeAStringPalindromic obj = new MinimumCharactersRequiredToMakeAStringPalindromic();
    System.out.println(obj.solve("aa12aaq"));
  }


  public int solve(String A) {
    int n=A.length();
    int i=n-1;
    while(i>=0){
      if(isPalindrome(A,0,i)){
        break;
      }
      i--;
    }
    return n-i-1;
  }

  private boolean isPalindrome(String A, int start, int end){
    while(start<end){
      if(A.charAt(start)!=A.charAt(end)){
        return false;
      }
      start++;
      end--;
    }
    return true;
  }


}
