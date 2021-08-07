package com.practice.strings;

public class AddBinaryStrings {

  public static void main(String[] args) {
    String a="100";
    String b="11";
    System.out.println(addBinary(a,b));

  }

  public static String addBinary(String A, String B) {
    char[] arrA = A.toCharArray();
    char[] arrB = B.toCharArray();
    int n = Math.max(A.length(),B.length());
    char[] result = new char[n];
    int i = arrA.length-1;
    int j = arrB.length-1;
    int k=n-1;
    boolean carry =false;
    while (i>=0 && j>=0){
      if(carry){
        if (arrA[i]=='1' && arrB[j]=='1'){
          result[k]='1';
          carry = true;
        }
        else if((arrA[i]=='1' && arrB[j]=='0')||(arrA[i]=='0' && arrB[j]=='1')){
          result[k]='0';
          carry = true;
        }
        else {
          result[k]='1';
          carry=false;
        }
      }
      else {
        if (arrA[i]=='1' && arrB[j]=='1'){
          result[k]='0';
          carry = true;
        }
        else if((arrA[i]=='1' && arrB[j]=='0')||(arrA[i]=='0' && arrB[j]=='1')){
          result[k]='1';
          carry = false;
        }
        else {
          result[k]='0';
        }
      }
      i--;
      j--;
      k--;
    }
    while (i>=0){
      if(carry ){
        if(arrA[i]=='0'){
          result[k]='1';
          carry=false;
        }
        else {
          result[k]='0';
          carry=true;
        }
      }
      else {
        result[k]=arrA[i];
      }
      i--;
      k--;
    }

    while (j>=0){
      if(carry ){
        if(arrB[j]=='0'){
          result[k]='1';
          carry=false;
        }
        else {
          result[k]='0';
          carry=true;
        }
      }
      else {
        result[k]=arrB[j];
      }
      j--;
      k--;
    }
    String res = new String(result);
    if(carry){
      res= "1"+res;
    }
    return res ;
  }


}
