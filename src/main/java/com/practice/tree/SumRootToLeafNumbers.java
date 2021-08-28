/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.

The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25
 */
package com.practice.tree;

import java.util.List;

public class SumRootToLeafNumbers {

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(5);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = new TreeNode(2);

    node1.left=node2;
    node2.left=node3;

    System.out.println(sumNumbers(node1));


  }

  static int totalSum=0;

  public static int sumNumbers(TreeNode A) {
    totalSumFun(A,0);
    return totalSum%1003;
  }


  public static void totalSumFun(TreeNode A, int sum) {
    if(A==null){
      return;
    }
    sum =(sum*10+A.val) %1003;
    if(A.left==null && A.right==null){
      totalSum =(totalSum+sum)%1003;
      return;
    }
    if(A.left != null){
      totalSumFun(A.left,sum);
    }
    if(A.right != null){
      totalSumFun(A.right,sum);
    }
  }

}
