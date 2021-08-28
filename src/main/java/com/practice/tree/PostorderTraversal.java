package com.practice.tree;

import java.util.ArrayList;

public class PostorderTraversal {

  ArrayList<Integer> postOrder= new ArrayList();
  public ArrayList<Integer> postorderTraversal(TreeNode A) {
    postorderT(A);
    return postOrder;

  }

  private void postorderT(TreeNode node) {
    if(node==null){
      return;
    }
    if(node.left!=null){
      postorderT(node.left);
    }
    if(node.right!=null){
      postorderT(node.right);
    }
    postOrder.add(node.val);
    return;
  }

}
