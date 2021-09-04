package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CycleInDirectedGraph {

  public int solve(int A, ArrayList<ArrayList<Integer>> B) {

    Map<Integer,List<Integer>> map = new HashMap();
    int n = B.size();
    for(int i=0;i<n;i++){
      int start = B.get(i).get(0);
      int end = B.get(i).get(1);
      if(map.get(start)==null){
        map.put(start,new ArrayList());
      }
      map.get(start).add(end);
    }
    Stack<Integer> stack = new Stack();
    Set<Integer> visited = new HashSet();
    stack.add(1);
    while(!stack.isEmpty()){
      int node = stack.pop();
      if(visited.contains(node)){
        return 1;
      }
      else{
        visited.add(node);
        if(map.get(node)!=null){
          stack.addAll(map.get(node));
        }
        else{
          visited.clear();
          visited.add(1);
        }
      }
    }
    return 0;
  }




  public int solve2(int A, ArrayList<ArrayList<Integer>> B) {
    Map<Integer,List<Integer>> map = new HashMap();
    int n = B.size();
    for(int i=0;i<n;i++){
      int start = B.get(i).get(0);
      int end = B.get(i).get(1);
      if(map.get(start)==null){
        map.put(start,new ArrayList());
      }
      map.get(start).add(end);
    }
    Stack<Integer> stack = new Stack();
    stack.ensureCapacity(B.size());
    boolean[] visited = new boolean[A];
    stack.add(1);
    while(!stack.isEmpty()){
      int node = stack.pop();
      if(visited[node-1]){
        return 1;
      }
      else{
        visited[node]=true;
        if(map.get(node)!=null){
          stack.addAll(map.get(node));
        }
        else{
          Arrays.fill(visited,false);
          visited[0]=true;
        }
      }
    }
    return 0;
  }

  private int isCycle(Map<Integer, List<Integer>> map, int node, Set<Integer> visited){
    List<Integer> outBounds = map.get(node);
    if(outBounds==null){
      return 0;
    }
    for(int i=0; i< outBounds.size(); i++){
      visited.add(node);
      if(isCycle(map,outBounds.get(i),visited)==1){
        return 1;
      }
      visited.clear();
    }
    return 0;
  }



  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

//    int[][] A = {  {1, 2},        {4, 1},        {2, 4},        {3, 4},        {5, 2},        {1, 3} };

    int[][] A = {  {1, 2},       {2, 3},        {3, 4},        {4, 5},        };


    for(int i=0;i<A.length;i++){
      ArrayList<Integer> list = new ArrayList<>();
      for(int j=0; j<A[i].length;j++){
        list.add(A[i][j]);
      }
      listArrayList.add(list);
    }
    return listArrayList;
  }



  private int isCyclic(int A, ArrayList<ArrayList<Integer>> B)
  {
    Map<Integer,List<Integer>> map = new HashMap();
    int n = B.size();
    for(int i=0;i<n;i++){
      int start = B.get(i).get(0);
      int end = B.get(i).get(1);
      if(map.get(start)==null){
        map.put(start,new ArrayList());
      }
      map.get(start).add(end);
    }

    // Mark all the vertices as not visited and
    // not part of recursion stack
    int V = B.size();
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];


    // Call the recursive helper function to
    // detect cycle in different DFS trees
    for (int i = 0; i < V; i++)
      if (isCyclicUtil(i, visited, recStack,map))
        return 1;

    return 0;
  }


  private boolean isCyclicUtil(int i, boolean[] visited,
      boolean[] recStack, Map<Integer, List<Integer>> map)
  {

    // Mark the current node as visited and
    // part of recursion stack
    if (recStack[i])
      return true;

    if (visited[i])
      return false;

    visited[i] = true;

    recStack[i] = true;
    List<Integer> children = map.get(i);

    for (Integer c: children)
      if (isCyclicUtil(c, visited, recStack, map))
        return true;

    recStack[i] = false;

    return false;
  }
}
