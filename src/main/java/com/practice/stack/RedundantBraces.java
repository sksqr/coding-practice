package com.practice.stack;

import java.util.Stack;

public class RedundantBraces {

  public static void main(String[] args) {
//    String A="((a + b))";
    String A="(a + (a + b))";
    System.out.println(braces(A));
  }

  public static int braces(String A) {
    Stack<Character> stack = new Stack<>();
    int n=A.length();
    for(int i=0;i<n;i++){
      if(A.charAt(i)==')')
      {
        if(stack.peek()=='('){
          return 1;
        }
        stack.pop();
        if(stack.peek()=='('){
          return 1;
        }
        while (stack.peek()!='('){
          stack.pop();
        }
        stack.pop();
      }
      else {
        stack.push(A.charAt(i));
      }
    }
    return 0;
  }
}
