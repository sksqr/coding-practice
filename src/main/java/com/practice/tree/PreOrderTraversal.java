package com.practice.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

  public static ArrayList<Integer> preorderTraversal(TreeNode A) {

    ArrayList<Integer> list = new ArrayList();
    Stack<TreeNode> stack = new Stack();
    if(A != null){
      stack.add(A);
    }
    while(!stack.isEmpty()){
      TreeNode node = stack.pop();
      list.add(node.val);
      if(node.right != null){
        stack.add(node.right);
      }

      if(node.left != null){
        stack.add(node.left);
      }

    }
    return list;
  }

}
