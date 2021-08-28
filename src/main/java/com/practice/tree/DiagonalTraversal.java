package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {

  public static void main(String[] args) {

    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);

    node1.left=node4;
    node1.right=node2;

    node2.right=node3;

    node3.left=node6;

    node4.left=node8;
    node4.right=node5;

    node5.left=node9;
    node5.right=node7;

    System.out.println(solve(node1));
  }

  public static ArrayList<Integer> solve(TreeNode A) {
    ArrayList<Integer> list= new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if(A==null){
      return list;
    }
    queue.add(A);
    while (!queue.isEmpty()){
      TreeNode node = queue.poll();
      while (node!=null){
        list.add(node.val);
        if(node.left!=null){
          queue.add(node.left);
        }
        node=node.right;
      }
    }
    return list;
  }


}
