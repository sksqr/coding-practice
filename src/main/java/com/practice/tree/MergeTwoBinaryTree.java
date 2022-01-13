package com.practice.tree;

public class MergeTwoBinaryTree  {
  /*
 A =  2
      / \

     1   4

    /

   5


B =   3
      / \
      6  1
      \   \
       2   7

    5
    / \
   7   5
  / \   \
 5   2   7
   */

  public TreeNode solve(TreeNode A, TreeNode B) {
    mergeBInA(A,B);
    return A;

  }


  private void mergeBInA(TreeNode A, TreeNode B){
    if(A!=null && B!=null){
      A.val = A.val +B.val;

      if(A.left==null && B.left!=null){
        A.left = B.left;
      }
      else {
        mergeBInA(A.left,B.left);
      }

      if(A.right==null && B.right!=null){
        A.right = B.right;
      }
      else {
        mergeBInA(A.right,B.right);
      }
    }
  }

}
