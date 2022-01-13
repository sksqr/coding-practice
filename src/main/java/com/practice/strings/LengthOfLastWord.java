package com.practice.strings;

public class LengthOfLastWord {

  public static void main(String[] args) {
    String s ="Wordl   ";
    String s2 ="d";
    String s3 ="hello world";
    String s4 ="hello world ";
    String s5 ="";
    System.out.println(lengthOfLastWord(s));
    System.out.println(lengthOfLastWord(s2));
    System.out.println(lengthOfLastWord(s3));
    System.out.println(lengthOfLastWord(s4));
    System.out.println(lengthOfLastWord(s5));

  }

  public static int lengthOfLastWord(final String A) {
    char[] arr = A.toCharArray();
    int n=arr.length;
    int i=n-1;
    while(i>=0 && arr[i]==' '){
      i--;
    }
    int last =i;
    if (i==-1){
      return 0;
    }


    while(i>=0){
      if(arr[i] == ' '){
        break;
      }
      i--;
    }

    return (last-i);
  }

}
