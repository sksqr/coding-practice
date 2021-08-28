package com.practice.tree;

public class KthSmallestElementInTree {

  private int count;
  private int smallest;
  public int kthsmallest(TreeNode A, int B) {
    count=B;
    kthSmall(A);
    return smallest;
  }
  private void kthSmall(TreeNode A){
    if(A==null){
      return;
    }

    kthSmall(A.left);
    count--;
    if(count==0){
      smallest=A.val;
      return;
    }
    kthSmall(A.right);
  }

}
