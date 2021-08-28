/*
 Inverting refers to making left child as the right child and vice versa.
 */


package com.practice.tree;


public class InvertTheBinaryTree {

  public TreeNode invertTree(TreeNode A) {
    invertTreeRec(A);
    return A;

  }


  private void invertTreeRec(TreeNode A) {
    if(A==null){
      return;
    }
    TreeNode temp = A.left;
    A.left = A.right;
    A.right = temp;
    invertTreeRec(A.left);
    invertTreeRec(A.right);
  }

}
