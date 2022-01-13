package com.practice.strings;

/*
Given a string A consisting only of lowercase characters, we need to check whether it is possible to make this string a palindrome after removing exactly one character from this.

If it is possible then return 1 else return 0.

abcba

abbad
 */

public class ConvertToPalindrome {

  public static void main(String[] args) {
    ConvertToPalindrome convertToPalindrome = new ConvertToPalindrome();
    String A="abcba";
    System.out.println(convertToPalindrome.solve(A));
  }
  public int solve(String A) {
    if(isPossible(A)){
      return 1;
    }
    return 0;
  }

  private boolean isPossible(String a){
    int n=a.length();
    int low=0;
    int high=n-1;
    int count=0;
    while(low<high){
      if(a.charAt(low) == a.charAt(high)){
        low++;
        high--;
      }
      else{
        if(low<high && a.charAt(low+1)==a.charAt(high)){
          low++;
          count++;
        }
        else if (low<high && a.charAt(low)==a.charAt(high-1)){
          high--;
          count++;
        }
        else {
          return false;
        }
      }
      if(count>1){
        return false;
      }
    }
    if(count==0 && n%2==0){
      return false;
    }
    return true;
  }

}
