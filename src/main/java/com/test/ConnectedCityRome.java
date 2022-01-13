package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
//task3

public class ConnectedCityRome {

  public static void main(String[] args) {
    int[] A = {2,3,3,4};
    int[] B = {1,1,0,0};
    ConnectedCityRome connectedCityRome = new ConnectedCityRome();
    System.out.println(connectedCityRome.solution(A,B));
  }

  public int solution(int[] A, int[] B) {
    // write your code in Java SE 8
    int n = A.length;
    int totalCities = countTotalCities(A,B);
    int[] routes = new int[totalCities];
    Arrays.fill(routes,totalCities-1);
    Map<Integer, List<Integer>> map = new HashMap();
    for(int i=0; i<n; i++){
      if(map.get(A[i])==null){
        map.put(A[i],new ArrayList());
      }
      map.get(A[i]).add(B[i]);
    }
    for(Integer key:map.keySet()){
      Set<Integer> visited = new HashSet();
      Queue<Integer> queue = new LinkedList();
      queue.add(key);

      while(!queue.isEmpty()){
        Integer city = queue.poll();
        if(!visited.contains(city)){
          routes[city]--;
          visited.add(city);
          if(map.get(city)!=null){
            queue.addAll(map.get(city));
          }
        }
      }
    }
    int rome=-1;
    for(int i=0; i<n+1;i++){
      if(routes[i]==0){
        rome=i;
        break;
      }
    }
    return rome;
  }

  private int countTotalCities(int[] A, int B[]){
    int n=A.length;
    Set<Integer> set = new HashSet();
    for(int i=0; i<n; i++){
      set.add(A[i]);
      set.add(B[i]);
    }
    return set.size();
  }

}
