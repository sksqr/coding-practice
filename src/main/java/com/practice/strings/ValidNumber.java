package com.practice.strings;

public class ValidNumber {

  public static void main(String[] args) {
//    System.out.println(isNumber("0"));
//    System.out.println(isNumber("0.1"));
//    System.out.println(isNumber("abc"));
//    System.out.println(isNumber("1 a"));
//    System.out.println(isNumber("2e10"));
//    System.out.println(isNumber("0"));
    System.out.println("01.1e10 : "+isNumber("01.1e10"));
    System.out.println("-01.1e10 : "+isNumber("-01.1e-10"));
    System.out.println(isNumber("3e1.1"));
    System.out.println(isNumber(" 1.1"));

  }

  public static int isNumber(final String A) {
    boolean eOccurred=false;
    int dotCount=0;
    int eCount=0;
    int minusCount=0;
    if(A.contains(".e")){
      return 0;
    }
    char[] arr = A.trim().toCharArray();
    int n=arr.length;
    if(n<=0){
      return 0;
    }
    if(arr[n-1]=='-'){
      return 0;
    }
    int start =0;
    if(arr[start]=='-'){
      start=1;
    }
    for(int i=start;i<n;i++){
      if(dotCount>1 || eCount >1 || minusCount>1){
        return 0;
      }
      if(!('0'<=arr[i] && arr[i]<='9')){
        if(arr[i]=='.'){
          if(eOccurred){
            return 0;
          }
          dotCount++;
        }
        else if(arr[i]=='e'){
          eCount++;
          eOccurred=true;
        }
        else if(arr[i]=='-'){
          minusCount++;
        }
        else {
          return 0;
        }
      }
    }
    return 1;
  }


}
