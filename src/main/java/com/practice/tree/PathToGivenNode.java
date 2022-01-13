package com.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PathToGivenNode {

  public int[] solve(TreeNode A, int B) {
    List<Integer> path = pathToB(A,B);
    int[] result = new int[path.size()];
    for(int i=0;i<path.size();i++){
      result[i] = path.get(i);
    }
    return result;
  }

  private List<Integer> pathToB(TreeNode A, int B){
    Queue<TreeNode> queue = new LinkedList();
    Map<TreeNode,List<Integer>> pathMap = new HashMap();
    queue.add(A);
    TreeNode destination = null;
    while(!queue.isEmpty()){
      TreeNode node = queue.poll();
      if(pathMap.get(node)==null){
        pathMap.put(node,new ArrayList());
      }
      if(node.val==B){
        destination=node;
        break;
      }
      if(node.left!=null)            {
        List<Integer> leftList = new ArrayList<>();
        leftList.addAll(pathMap.get(node));
        leftList.add(node.left.val);
        pathMap.put(node.left,leftList);
        queue.add(node.left);
      }

      if(node.right!=null)            {
        List<Integer> rightList = new ArrayList<>();
        rightList.addAll(pathMap.get(node));
        rightList.add(node.right.val);
        pathMap.put(node.right,rightList);
        queue.add(node.right);
      }
    }
    return pathMap.get(destination);
  }


  public int[] solveRec(TreeNode A, int B) {
    List<Integer> path = new ArrayList();
    int[] result = new int[0];
    if(pathToBRec(A,B,path)){
      result = new int[path.size()];
      int j=0;
      for(int i=path.size()-1;i>=0;i--){
        result[j] = path.get(i);
        j++;
      }
    }
    return result;
  }


  private boolean pathToBRec(TreeNode A, int B, List<Integer> path){
    if(A==null){
      return false;
    }
    if(A.val==B){
      path.add(A.val);
      return true;
    }
    if(pathToBRec(A.left,B,path)){
      path.add(A.val);
      return true;
    }
    if(pathToBRec(A.right,B,path)){
      path.add(A.val);
      return true;
    }
    return false;
  }

}
