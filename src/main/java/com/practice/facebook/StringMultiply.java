package com.practice.facebook;

public class StringMultiply {

  public static void main(String[] args) {
    StringMultiply obj = new StringMultiply();
    System.out.println(obj.multiply("999","999"));
  }

  public String multiply(String num1, String num2) {

    if(num1.equals("0") || num2.equals("0")){
      return "0";
    }

    int l1 = num1.length();
    int l2 = num2.length();


    StringBuilder r = new StringBuilder();

    for(int i=l1-1; i>=0; i--){
      StringBuilder sub = new StringBuilder();
      for(int k=l1-1; k>i; k--){
        sub.append("0");
      }
      int k=sub.length();
      int n1 = Integer.valueOf(num1.charAt(i)) - '0';
      int carry=0;
      for(int j=l2-1; j>=0; j--){
        int n2 = Integer.valueOf(num2.charAt(j)) - '0';
        int mul = (n1*n2+carry);
        carry = mul/10;
        int rem = mul%10;
        sub.append(rem);
      }
      if(carry!=0){
        sub.append(carry);
      }
      if(r.length()==0){
        r = sub;
      }
      else{
        int l=0;
        int c=0;
        while(l<r.length() && l<sub.length()){
          int add = (Integer.valueOf(r.charAt(l))-'0')  + (Integer.valueOf(sub.charAt(l))-'0') +c;
          c = add/10;
          int re = add%10;
          r.setCharAt(l,(char)(re+'0'));
          l++;
        }
        while(l<sub.length()){
          int add = (Integer.valueOf(sub.charAt(l))-'0')  +c;
          c = add/10;
          int re = add%10;
          r.append((char)(re+'0'));
          l++;
        }
        if(c!=0){
          r.append(c);
        }
      }

    }
    return r.reverse().toString();

  }

}
/*
8631
0219
____
88401
 */
