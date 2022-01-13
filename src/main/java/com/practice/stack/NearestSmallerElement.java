package com.practice.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1);

    System.out.println(prevSmaller(list));
  }



  public static ArrayList<Integer> prevSmaller(List<Integer> A) {
    int n=A.size();
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    // Traverse all array elements
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result.add(-1);
      } else
      {
        result.add(stack.peek());
      }
      stack.push(A.get(i));
    }
    return  result;
  }

  public static ArrayList<Integer> prevSmaller2(List<Integer> A) {
    int n=A.size();
    ArrayList<Integer> result = new ArrayList<>();
    for(int i=0;i<n;i++){
      boolean flag=false;
      for(int j=i-1; j>=0;j--){
        if(A.get(j) < A.get(i)){
          result.add(A.get(j));
          flag=true;
          break;
        }
      }
      if(!flag){
        result.add(-1);
      }
    }
    return  result;
  }

}
