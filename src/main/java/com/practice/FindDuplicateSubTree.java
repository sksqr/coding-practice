package com.practice;
/*
            1
         2     3
       / \      \
      4   5      2
                  \
                    5
 */

import java.util.ArrayList;
import java.util.List;

class Node{
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    left=null;
    right=null;
  }
}

/*
            1
         2     3
       / \      \
      4   5      2
                  \
                    5
 */
public class FindDuplicateSubTree {

  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node two2 = new Node(7);
    Node five2 = new Node(8);
    one.left=two;
    one.right=three;

    two.left=four;
    two.right=five;

    three.right=two2;
    two2.right=five2;

    System.out.println(isDuplicate(one));


  }


  private static boolean isDuplicate(Node root){
    List<Node> list = new ArrayList<>();
    inorder(root,list);
    int i=0;
    int j=1;
    int n= list.size();
    while (i<n){
      j=i+1;
      while (j<n){
        if(list.get(j)==null){
          if(j<n-1 && i<n-1 && i!=j && list.get(i+1).data == list.get(j+1).data){
            return true;
          }
        }
        j++;
      }
      i++;
      while (i<n && list.get(i)!=null ){
        i++;
      }
    }
    return false;
  }

  private  static void inorder(Node root, List<Node> list){
    if(root==null){
      return;
    }
    inorder(root.left,list);
    if(root.left==null && root.right == null){
      list.add(null);
    }
    list.add(root);
    inorder(root.right,list);
  }

}
