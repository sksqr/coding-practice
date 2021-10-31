package com.practice.facebook;

import com.practice.tree.TreeNode;


public class ConvertBinaryTreeToDoublyLinkedList {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node.left=node2;
    TreeNode node3 = new TreeNode(3);
    node.right=node3;
    TreeNode node4 = new TreeNode(4);
    node3.right=node4;

    TreeNode head = convert_to_linked_list(node,true);
    System.out.println(head);

  }


  public static TreeNode convert_to_linked_list(TreeNode node,boolean rightSubTree){
    if(node==null){
      return null;
    }

    TreeNode right = convert_to_linked_list(node.right,true);
    TreeNode left = convert_to_linked_list(node.left,false);
    if(left!=null){
      left.right=node;
      node.left=left;
    }
    if(right!=null){
      right.left=node;
      node.right=right;
    }
    if(rightSubTree){
      TreeNode temp=node.left;
      while (temp!=null){
        node=temp;
        temp=temp.left;
      }
      return node;
    }
    TreeNode temp=node.right;
    while (temp!=null){
      node=temp;
      temp=temp.right;
    }
    return node;
  }

}
