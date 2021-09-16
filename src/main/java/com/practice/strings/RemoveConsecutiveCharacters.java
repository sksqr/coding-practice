package com.practice.strings;

public class RemoveConsecutiveCharacters {

  public static void main(String[] args) {

    RemoveConsecutiveCharacters obj = new RemoveConsecutiveCharacters();
    System.out.println(obj.solve("aabccd",2));
    System.out.println(obj.solve("aaagccc",2));

  }

  public String solve(String A, int B) {
    int n = A.length();
    char[] result = new char[n];
    int k=0;
    int i=0;
    char prev = A.charAt(i);
    result[k]= A.charAt(i);
    k++;
    i++;
    int count=1;
    while (i<n){

      if(count==B && A.charAt(i)!=prev){
        k=k-B;
        result[k]=A.charAt(i);
        prev=A.charAt(i);
        k++;
        i++;
        count=1;
      }
      else if( A.charAt(i)==prev){
        result[k]=A.charAt(i);
        k++;
        i++;
        count++;
      }
      else {
        result[k]=A.charAt(i);
        prev=A.charAt(i);
        k++;
        i++;
        count=1;
      }
    }
    if(count==B){
      k=k-B;
    }
    String res = new String(result);
    return res.substring(0,k);
  }

}
