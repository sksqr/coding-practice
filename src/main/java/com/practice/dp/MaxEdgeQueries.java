package com.practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge{
  int s1;
  int s2;
  int wt;

  public Edge(int a, int b, int c){
    s1=a;
    s2=b;
    wt=c;
  }
}

public class MaxEdgeQueries {
  Map<Integer, List<Edge>> edgeMap = new HashMap();

  Set<Edge> edgeSet = new HashSet();

  public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
    int n=A.size();
    for(int i=0;i<n; i++){
      ArrayList<Integer> list = A.get(i);
      int s1=list.get(0);
      int s2=list.get(1);
      int wt=list.get(2);
      Edge edge = new Edge(s1,s2,wt);
      if(edgeMap.get(s1)==null){
        edgeMap.put(s1, new ArrayList());
      }
      edgeMap.get(s1).add(edge);
      if(edgeMap.get(s2)==null){
        edgeMap.put(s2, new ArrayList());
      }
      edgeMap.get(s2).add(edge);
    }
    ArrayList<Integer> result = new ArrayList();
    int t=B.size();
    for(int i=0; i<t; i++){
      int source = B.get(i).get(0);
      int destination = B.get(i).get(1);
      result.add(getMaxWt(source,destination,0));
    }
    return result;
  }

  private int getMaxWt(int a, int b, int max){

    List<Edge> edgeList = edgeMap.get(a);
    if(edgeList==null){
      return -1;
    }

    int newMax =0;
    for(int i=0; i<edgeList.size(); i++){
      Edge edge = edgeList.get(i);
      if(edgeSet.contains(edge)){
        continue;
      }
      int subMax=-1;
      if(edge.s1==b || edge.s2==b){
        if(edge.wt > max){
          return edge.wt;
        }
        else{
          return max;
        }
      }
      else if(edge.s1==a){
        if(edge.wt > max){
          subMax = getMaxWt(edge.s2,b,edge.wt);
        }
        else{
          subMax = getMaxWt(edge.s2,b,max);
        }
      }
      else{
        if(edge.wt > max){
          subMax =  getMaxWt(edge.s1,b,edge.wt);
        }
        else{
          subMax = getMaxWt(edge.s1,b,max);
        }
      }
      if(subMax>newMax){
        newMax=subMax;
      }

    }
    return newMax;

  }
}

