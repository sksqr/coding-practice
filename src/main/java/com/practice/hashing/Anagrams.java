package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Anagrams {

  public static void main(String[] args) {
    List<String> stringList = Arrays.asList("cat", "dog", "god", "tca");
    System.out.println(anagrams(stringList));
  }

  public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    Map<String,ArrayList<Integer>> mapStringIndex = new LinkedHashMap<>();
    int n = A.size();
    for(int i=0;i<n;i++){
      String str = A.get(i);
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String sortedStr = new String(arr);
      if(mapStringIndex.containsKey(sortedStr)){
        mapStringIndex.get(sortedStr).add(i+1);
      }
      else{
        mapStringIndex.put(sortedStr,new ArrayList<>());
        mapStringIndex.get(sortedStr).add(i+1);
      }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for(String key : mapStringIndex.keySet()){
      result.add(mapStringIndex.get(key));
    }
    return result;
  }

}
