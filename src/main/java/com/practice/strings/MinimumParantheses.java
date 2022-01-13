package com.practice.strings;

import java.util.Stack;

public class MinimumParantheses {

  public int solve(String A) {
    int openCount=0;
    int closeCount=0;
    int n=A.length();
    Stack<Character> stack = new Stack();
    for(int i=0;i<n;i++){
      if(A.charAt(i)=='('){
        stack.push(A.charAt(i));
      }
      else{
        if(stack.isEmpty()){
          openCount++;
        }
        else if(stack.peek()!='('){
          openCount++;
        }
        else{
          stack.pop();
        }
      }
    }
    closeCount = stack.size();
    return Math.abs(openCount+closeCount);
  }


}
