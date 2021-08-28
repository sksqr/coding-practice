package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

  private  static Map<Character, List<Character>> numberToCharMap = new HashMap<>();

  static {
    List<Character> list0 = new ArrayList<>();
    list0.add('0');
    numberToCharMap.put('0',list0);
    List<Character> list1 = new ArrayList<>();
    list1.add('1');
    numberToCharMap.put('1',list1);

    List<Character> list2 = Arrays.asList('a', 'b','c');
    numberToCharMap.put('2',list2);

    List<Character> list3 = Arrays.asList('d', 'e','f');
    numberToCharMap.put('3',list3);

    List<Character> list4 = Arrays.asList('g', 'h','i');
    numberToCharMap.put('4',list4);

    List<Character> list5 = Arrays.asList('j', 'k','l');
    numberToCharMap.put('5',list5);

    List<Character> list6 = Arrays.asList('m', 'n','o');
    numberToCharMap.put('6',list6);

    List<Character> list7 = Arrays.asList('p', 'q','r','s');
    numberToCharMap.put('7',list7);

    List<Character> list8 = Arrays.asList('t', 'u','v');
    numberToCharMap.put('8',list8);

    List<Character> list9 = Arrays.asList('w', 'x','y','z');
    numberToCharMap.put('9',list9);


  }

  public static void main(String[] args) {
    String A = "23";
    System.out.println(letterCombinations(A));
  }

  private static ArrayList<String> combinations(String A, int start) {
    if(start==A.length()-1){
      ArrayList<String> list = new ArrayList<>();
      numberToCharMap.get(A.charAt(start)).forEach(character -> list.add(character.toString()));
      return list;
    }
    ArrayList<String> subResult = combinations(A,start+1);
    char c = A.charAt(start);
    List<Character> possibleChar = numberToCharMap.get(c);
    ArrayList<String> result = new ArrayList<>();
    for(int i=0;i<possibleChar.size();i++){
      for(int j=0;j<subResult.size(); j++){
        StringBuilder sb = new StringBuilder();
        sb.append(possibleChar.get(i));
        sb.append(subResult.get(j));
        result.add(sb.toString());
      }
    }
    return result;
  }

  public static ArrayList<String> letterCombinations(String A) {
    return combinations(A,0);
  }

}
