package com.practice.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PuzzleWords {
/*
["apple","pleas","please"]
["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
 */
  public static void main(String[] args) {
    PuzzleWords obj = new PuzzleWords();
//    String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
//    String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

    String[] words = {"apple","pleas","please"};
    String[] puzzles = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};
    System.out.println(obj.findNumOfValidWords(words,puzzles));
  }

  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

    int n = puzzles.length;
    Map<String,Set<Character>> map = new HashMap();
    for(int i=0; i<n; i++){
      Set<Character> set = new HashSet();
      String p = puzzles[i];
      for(int k=0; k<p.length(); k++ ){
        set.add(p.charAt(k));
      }
      map.put(p,set);
    }

    int totalWords = words.length;
    Map<String,Set<Character>> wordSetMap = new HashMap();
    for(int i=0; i<totalWords; i++){
      Set<Character> set = new HashSet();
      String w = words[i];
      for(int k=0; k<w.length(); k++ ){
        set.add(w.charAt(k));
      }
      wordSetMap.put(w,set);
    }

    List<Integer> result = new ArrayList();
    for(int i=0; i<n; i++){
      String p = puzzles[i];
      Set<Character> pSet = map.get(p);
      int count=0;
      for(int j=0; j<totalWords; j++ ){
        String word = words[j];
        Set<Character> wSet = wordSetMap.get(word);
        if(!wSet.contains(p.charAt(0))){
          continue;
        }
        if(pSet.containsAll(wSet)){
          count++;
        }
      }
      result.add(count);
    }
    return result;

  }

}
