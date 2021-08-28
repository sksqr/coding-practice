package com.practice.strings;

public class ReverseString {

  public static void main(String[] args) {
    String str = "abcd";
    System.out.println("Reverse with StringBuilder: "+reverseString(str));
    System.out.println("Reverse with arr: "+reverseStringWithOutExtraSpace(str));

  }

  private static String reverseString(String str){
    return new StringBuilder(str).reverse().toString();
  }

  private static String reverseStringWithOutExtraSpace(String str){
    char[] arr = str.toCharArray();
    int start=0;
    int end=arr.length-1;
    while (start < end && start<= arr.length/2){
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    return new String(arr);
  }



}
