package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import com.practice.tree.TreeNode;
import java.util.Queue;


public class LevelOrder {

  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
    ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    if(A==null){
      return levels;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(A);
    queue.add(null);
    ArrayList<Integer> currentLevel = new ArrayList<>();
    while (!queue.isEmpty()){
      TreeNode node = queue.poll();
      if (node!=null){
        currentLevel.add(node.val);
        if(node.left!=null){
          queue.add(node.left);
        }
        if(node.right!=null){
          queue.add(node.right);
        }
      }
      else {
        levels.add(currentLevel);
        currentLevel = new ArrayList<>();
        if(!queue.isEmpty()){
          queue.add(null);
        }
      }
    }
    return levels;
  }

}
