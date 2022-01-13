package com.practice.tree;

import java.util.ArrayList;

public class Cousins {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node.left=node2;
    TreeNode node3 = new TreeNode(3);
    node.right=node3;
    TreeNode node4 = new TreeNode(4);
    node3.right=node4;

    Cousins cousins = new Cousins();
    System.out.println(cousins.solve(node,2));
  }

  private ArrayList<Integer>  cousins;

  public ArrayList<Integer> solve(TreeNode A, int B) {
    return getCousins(A,B);
  }

  int getHight(TreeNode A, int B, int cur){
    if(A==null){
      return 0;
    }
    if(A.val == B){
      return cur;
    }
    return Math.max(getHight(A.left,B,cur+1),getHight(A.right,B,cur+1));
  }

  ArrayList<Integer> getCousins(TreeNode A, int B){
    int ht = getHight(A,B,0);
    cousins = new ArrayList();
    //    System.out.println(ht);
    fillCousins(A,B,ht,0);
    return cousins;
  }

  void fillCousins(TreeNode A, int B, int ht, int currHt){
    if(A==null){
      return;
    }
    if(currHt > ht){
      return;
    }
    if(currHt == ht-1){
      if(A.left!=null && A.left.val == B){
        return;
      }
      if((A.right!=null && A.right.val == B)){
        return;
      }
      if(A.left!=null){
        cousins.add(A.left.val);
      }
      if(A.right!=null){
        cousins.add(A.right.val);
      }
    }
    fillCousins(A.left,B,ht,currHt+1);
    fillCousins(A.right,B,ht,currHt+1);
  }

}
