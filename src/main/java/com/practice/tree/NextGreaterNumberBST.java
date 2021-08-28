package com.practice.tree;

public class NextGreaterNumberBST {

  TreeNode prevNearestMax =null;
  public TreeNode getSuccessor(TreeNode a, int b) {
    getSuccessorRec(a,b);
    return prevNearestMax;
  }

  void getSuccessorRec(TreeNode a, int b){
    if(a==null){
      return ;
    }
    if(prevNearestMax==null && a.val>b){
      prevNearestMax=a;
    }
    if(a.val>b && a.val-b < prevNearestMax.val-b){
      prevNearestMax = a;
    }
    if(b < a.val){
      getSuccessorRec(a.left,b);
    }
    else{
      getSuccessorRec(a.right,b);
    }
    return;
  }

}
