package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class PalindromePartitioning {

  public static void main(String[] args) {
    String a= "cccaacbcaabb";
    PalindromePartitioning palindromePartitioning =new PalindromePartitioning();
    System.out.println(palindromePartitioning.partition(a));


  }

  public ArrayList<ArrayList<String>> partition(String a) {
    ArrayList<ArrayList<String>> result = partitionRec(a);
    Collections.sort(result, (l1,l2)->{
      int i=0;
      while (i<l2.size() && i<l2.size()){
        if(l1.get(i).length() != l2.get(i).length() ){
          return l1.get(i).length() - l2.get(i).length();
        }
        i++;
      }
      return l1.size()-l2.size();
    });
    return  result;
  }


  private ArrayList<ArrayList<String>> partitionRec(String a) {
    int cut = a.length();
    ArrayList<ArrayList<String>> result = new ArrayList();
    if(cut==0){
      result.add(new ArrayList<>());
      return result;
    }
    for(int i=cut; i>0;i--){
      String str = a.substring(0,i);
      if(isPalindrome(str)){
        ArrayList<ArrayList<String>> subResult = partitionRec(a.substring(i,cut));
        for(ArrayList<String> list : subResult){
          ArrayList<String> list1 = new ArrayList<>();
          list1.add(str);
          list1.addAll(list);
          result.add(list1);
        }

      }
    }
    return result;
  }


  private boolean isPalindrome(String s){
    int n = s.length();
    int start=0;
    int end=n-1;
    while(start<end){
      if(s.charAt(start)!=s.charAt(end)){
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
