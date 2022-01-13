package com.practice.strings;
/*
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
 */

public class ReverseTheString {

  public static void main(String[] args) {
    ReverseTheString reverseTheString = new ReverseTheString();
    String A = "qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo";
    System.out.println(reverseTheString.reverseWordByWord(A));
  }

  public String reverseWordByWord(String A) {
    A = A.trim();
    String[] word = A.split(" ");
    StringBuilder sb = new StringBuilder();
    int n = word.length;
    for (int i = n - 1; i >= 0; i--) {
      if (word[i].length() != 0) {
        sb.append(word[i]);
        sb.append(" ");
      }
    }
    String result = sb.toString().trim();
    return result;
  }

  public String reverseWordByWord2(String A) {
    A.trim();
    char[] arr = A.toCharArray();
    reverse(arr,0,A.length()-1);
    int start=0;
    int end=A.length()-1;
    for(int i=0;i<A.length();i++){
      if(arr[i]==' '){
        end=i-1;
        reverse(arr,start,end);
        start=i+1;
      }
      else if(i==A.length()-1){
        end=i;
        reverse(arr,start,end);
      }
    }
    return new String(arr);
  }


  void reverse(char[] array, int start, int end){
    while(start<end){
      char temp = array[start];
      array[start]=array[end];
      array[end] = temp;
      start++;
      end--;
    }
  }

}
