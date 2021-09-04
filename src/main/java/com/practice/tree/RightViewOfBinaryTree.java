package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

  public ArrayList<Integer> solve(TreeNode A) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();
    queue.add(null);
    queue.add(A);
    while (!queue.isEmpty()){
      TreeNode node = queue.poll();
      if(node==null){
        if(!queue.isEmpty() && queue.peek()!=null){
          node = queue.poll();
          result.add(node.val);
          queue.add(null);
        }
      }
      if(node!=null){
        if(node.right!=null){
          queue.add(node.right);
        }
        if(node.left!=null){
          queue.add(node.left);
        }
      }
    }
    return result;
  }

}
