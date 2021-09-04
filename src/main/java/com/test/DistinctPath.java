package com.test;


import java.util.HashSet;
import java.util.Set;
//task2
class Tree{
  public int x;
  public Tree l;
  public Tree r;
}

public class DistinctPath {

  public int solution(Tree T) {
    // write your code in Java SE 8
    Set<Integer> set = new HashSet();
    return distinctPath(T,set,null);
  }
  private int distinctPath(Tree T, Set<Integer> path, Integer lastAdded){
    int length = path.size();
    if(T==null || path.contains(T.x)){
      path.remove(lastAdded);
      return length;
    }
    path.add(T.x);
    int left = distinctPath(T.l,path,T.x);
    path.add(T.x);
    int right = distinctPath(T.r,path,T.x);
    return Math.max(left,right);
  }

}
