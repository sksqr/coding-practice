package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

  public static void main(String[] args) {
    List<String> dic = Arrays.asList("cat", "cats", "and", "sand", "dog");
    String A = "catsanddog";
    WordBreakII wordBreakII = new WordBreakII();
    System.out.println(wordBreakII.wordBreak(A,new ArrayList<>(dic)));
  }

  private Set<String> dictionary= new HashSet();
  private Map<Integer, ArrayList<String>> map = new HashMap<>();
  public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
    dictionary.addAll(B);
    ArrayList<String> result= wordBreakRec(A,0);
    if(result==null){
      return new ArrayList();
    }
    return result;
  }

  public ArrayList<String> wordBreakRec(String A,int i) {
    if(map.get(i)!=null){
      return map.get(i);
    }
    if(i==A.length()){
      ArrayList<String> result = new ArrayList();
      result.add("");
      map.put(i,result);
      return result;
    }
    int k=i+1;
    String word="";
    boolean flag = false;
    ArrayList<String> sentences = new ArrayList();
    while(!flag && k<A.length()+1){
      if(!dictionary.contains(A.substring(i,k))){
        k++;
        continue;
      }
      word = A.substring(i,k);
      ArrayList<String> subSentences = wordBreakRec(A,k);
      if(subSentences == null){
        k++;
        continue;
      }
      else{
        for(int j=0;j<subSentences.size();j++){
          String sent = word+" "+subSentences.get(j);
          sentences.add(sent.trim());
        }
//        return sentences;
        k++;
      }
    }
    map.put(i,sentences.isEmpty()?null:sentences);
    return map.get(i);
  }

}
