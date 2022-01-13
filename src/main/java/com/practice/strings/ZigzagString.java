package com.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigzagString {

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR"));
  }

  public static String convert(String A, int B) {
    List<List<Character>> mat = new ArrayList();
    for(int i=0; i<B;i++){
      mat.add(new ArrayList());
    }
    int n=A.length();
    boolean lowDir = true;
    int row = 0;
    for(int i=0; i<n;i++){
      mat.get(row).add(A.charAt(i));
      if(lowDir){
        if(row== B-1){
          row--;
          lowDir=false;
        }
        else {
          row++;
        }
      }
      else {
        if(row== 0){
          row++;
          lowDir=true;
        }
        else {
          row--;
        }
      }
    }
    StringBuilder sb = new StringBuilder(n);
    mat.stream().forEach(list -> list.forEach(character -> sb.append(character)));
    return sb.toString();
  }

}
