package com.practice.maths;

public class ExcelColumnNo {

  public static void main(String[] args) {
    System.out.println(titleToNumber("B"));
    System.out.println(titleToNumber("AB"));
    System.out.println(titleToNumber("AZ"));
    System.out.println(titleToNumber("BA"));
  }

  public static int titleToNumber(String A) {
    int num = 0;
    char[] arr = A.toCharArray();
    int i=0;
    int n=A.length();


    while (i<n){
      num += (arr[i]-'A'+1)*Math.pow(26,n-i-1);
      i++;
    }
    return num;
  }



}
