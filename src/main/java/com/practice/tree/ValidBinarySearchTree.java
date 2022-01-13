package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 */


public class ValidBinarySearchTree {

  public static void main(String[] args) {
//    TreeNode node1 = new TreeNode(1);
//    TreeNode node2 = new TreeNode(2);
//    TreeNode node3 = new TreeNode(3);
//    TreeNode node4 = new TreeNode(4);
//    TreeNode node5 = new TreeNode(5);

    TreeNode node1 = new TreeNode(11);
    TreeNode node2 = new TreeNode(4);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(1);
    TreeNode node6 = new TreeNode(5);

    node1.left=node2;
    node1.right=node3;

    node2.left=node4;
    node2.right=node5;

    node3.left=node6;
    ValidBinarySearchTree obj = new ValidBinarySearchTree();
    System.out.println(obj.isValidBSTWithTraversal(node1));

  }

  List<Integer> inorder = null;

  public  int isValidBSTWithTraversal(TreeNode A) {
    inorder = new ArrayList<>();
    inorderTraversal(A);
    for(int i=0;i<inorder.size()-1;i++){
      if(inorder.get(i) > inorder.get(i+1)){
        return 0;
      }
    }
    return -1;
  }

  private  void inorderTraversal(TreeNode A){
    if(A==null){
      return;
    }
    inorderTraversal(A.left);
    inorder.add(A.val);
    inorderTraversal(A.right);
  }



  public static int isValidBST(TreeNode A) {
    if(A==null){
      return 1;
    }
    if(A.left != null && A.left.val > A.val){
      return 0;
    }
    if(A.right != null && A.right.val < A.val){
      return 0;
    }
    int leftValid = isValidBST(A.left);
    int rightValid = isValidBST(A.right);
    if(leftValid==0 || rightValid==0){
      return 0;
    }
    return 1;
  }

}
