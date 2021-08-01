package com.practice.maths;

public class PalindromeInteger {

  public static void main(String[] args) {
    System.out.println(isPalindrome(11021));
  }


  public static   int isPalindrome(int A) {
    int divd = A;

    int rev =0;
    while (divd > 0){
      int rem = divd%10;
      divd = divd/10;
      rev = (rev*10)+rem;
    }
    if(rev == A){
      return 1;
    }
    return 0;
  }

}
