package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*


Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7

Output 1:

 [15, 7, 9, 20, 3]
 */

public class ReverseLevelOrder {


  public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//    TreeNode node2 = new TreeNode(2);
//    TreeNode node3 = new TreeNode(3);
//    TreeNode node4 = new TreeNode(4);
//    TreeNode node5 = new TreeNode(5);

    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20);
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);


    node1.left=node2;
    node1.right=node3;

    node3.left=node4;
    node3.right=node5;
//System.out.println(preorderTraversal(node1));
    System.out.println(solve(node1));
  }

  public static ArrayList<Integer> solve(TreeNode A) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(A);
    queue.add(null);
    List<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()){
      TreeNode node = queue.poll();
      if(node==null){
        lists.add(list);
        if(queue.peek()!=null){
          queue.add(null);
        }
        list = new ArrayList<>();
      }
      else {
        list.add(node.val);
        if(node.right != null){
          queue.add(node.right);
        }
        if(node.left != null){
          queue.add(node.left);
        }

      }
    }
    ArrayList<Integer> result= new ArrayList<>();
    for(int i=lists.size()-1; i>=0; i--){
      result.addAll(lists.get(i));
    }
    return result;
  }



}
