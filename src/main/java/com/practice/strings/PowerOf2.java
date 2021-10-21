package com.practice.strings;

public class PowerOf2 {

  public static void main(String[] args) {
    String A="2560";
//    System.out.println(divide("2242"));
    System.out.println(power(A));
  }


  public static int power(String A) {
    while (!A.equals("1")){
      A = divide(A);
      if(A.equals("false")){
        return 0;
      }
    }
    return 1;
  }

  private static String divide(String A){
    int n=A.length();
    StringBuilder sb = new StringBuilder();
    int num = 0;
    int rem=0;
    int k=0;
    while (A.charAt(k)=='0'){
      k++;
    }
    for(int i=k;i<n;i++){
      num = num*10 + (A.charAt(i)-'0');
      int q = num/2;
      sb.append(q);
      rem = num%2;
      num = rem;
    }
    if(rem!=0){
      return "false";
    }
    return sb.toString();
  }

}
