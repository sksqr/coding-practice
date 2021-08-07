package com.practice.strings;

public class PalindromeString {

  public int isPalindrome(String A) {
    A = A.toLowerCase();
    int i=0;
    int j=A.length()-1;
    char c ='a';
    char cj ='a';
    while(i<=j){

      while(i<=j &&!('a'<=A.charAt(i) && A.charAt(i)<='z') && !('A'<=A.charAt(i) && A.charAt(i)<='Z') && !('0'<=A.charAt(i) && c<='9')  ){
        i++;
      }

      while(i<=j && !('a'<=A.charAt(j) && A.charAt(j)<='z') && !('A'<=A.charAt(j) && A.charAt(j)<='Z') && !('0'<=A.charAt(j) && A.charAt(j)<='9') && i<=j ){
        j--;
      }
      if(i<=j){
        c = A.charAt(i);
        cj = A.charAt(j);
        if(c != cj){
          return 0;
        }
      }
      i++;
      j--;
    }
    return 1;
  }

}
