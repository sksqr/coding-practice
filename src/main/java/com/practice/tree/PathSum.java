package com.practice.tree;

public class PathSum {

  public int hasPathSum(TreeNode A, int B) {
    if(A.left==null && A.right==null && A.val==B){
      return 1;
    }
    int path=0;
    if(A.left!=null){
      path = hasPathSum(A.left,B-A.val);
    }
    if(A.right!=null && path!=1){
      path = hasPathSum(A.right,B-A.val);
    }
    return path;
  }

}
