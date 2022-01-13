package com.practice.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {

  interface BinaryOperation{
    int operate(int n1,int n2);
  }

  public static void main(String[] args) {
    List<String> exp = Arrays.asList("2", "1", "+", "3", "*");
    System.out.println("Result:"+evalRPN(exp));
  }

  public static   int evalRPN(List<String> A) {
    Map<String,BinaryOperation> operation = new HashMap<>();
    operation.put("+",(n1,n2) -> n1+n2);
    operation.put("-",(n1,n2) -> n1-n2);
    operation.put("*",(n1,n2) -> n1*n2);
    operation.put("/", (n1,n2) -> n1/n2);

    Stack<Integer> stack = new Stack();
    int n=A.size();
    for(int i=0;i<n;i++){
      if(operation.containsKey(A.get(i))){
        int n2 = stack.pop();
        int n1 = stack.pop();
        int ans = operation.get(A.get(i)).operate(n1,n2);
        stack.push(ans);
      }
      else {
        stack.push(Integer.valueOf(A.get(i)));
      }
    }
    return stack.pop();
  }

  private static int operation(String operator, int n1, int n2){
    if("+".equals(operator)){
      return n1 + n2;
    }
    else if("-".equals(operator)){
      return n1 - n2;
    }
    else if("*".equals(operator)){
      return n1 * n2;
    }
    else{
      return n1 / n2;
    }

  }

}
