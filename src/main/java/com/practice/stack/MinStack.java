package com.practice.stack;

import java.util.Stack;

public class MinStack {

  private Stack<Integer> stack = new Stack();
  private Stack<Integer> minStack = new Stack();

  public void push(int x) {
    stack.push(x);
    if(minStack.isEmpty()){
      minStack.push(x);
    }
    else{
      int min = minStack.peek();
      if(x < minStack.peek()){
        minStack.push(x);
      }
      else{
        minStack.push(min);
      }
    }
  }

  public void pop() {
    if(stack.isEmpty()){
      return;
    }
    minStack.pop();
    stack.pop();
  }

  public int top() {
    if(stack.isEmpty()){
      return -1;
    }
    return stack.peek();
  }

  public int getMin() {
    if(minStack.isEmpty()){
      return -1;
    }
    return minStack.peek();
  }

}
