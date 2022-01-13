package com.practice.stack;

import java.util.Stack;

public class SimplifyDirectoryPath {

  public static void main(String[] args) {
    SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
    System.out.println(simplifyDirectoryPath.simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyDirectoryPath.simplifyPath("/home///test//"));
    System.out.println(simplifyDirectoryPath.simplifyPath("/../"));
  }

  public String simplifyPath(String A) {
    int n = A.length();
    StringBuilder path = new StringBuilder();

    Stack<String> stack = new Stack<>();
    String[] dirName = A.split("/");
    for(int i=0;i<dirName.length;i++){
      String s = dirName[i];
      if(s.equals(".") || s.equals("")){
        ;
      }
      else if(s.equals("..") ){
        if(!stack.isEmpty()){
          stack.pop();
        }
      }
      else {
        stack.push(s);
      }
    }

    if(stack.empty()){
      path.append("/");
    }
    Stack<String> temp = new Stack<>();
    while (!stack.isEmpty()){
      temp.push(stack.pop());
    }
    while (!temp.isEmpty()){
      path.append("/");
      path.append(temp.pop());
    }
    return path.toString();
  }

}
