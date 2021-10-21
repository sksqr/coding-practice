package com.practice.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

  public static void main(String[] args) {
    RomanToInteger romanToInteger = new RomanToInteger();

    System.out.println(romanToInteger.romanToInt("MDCCCIV"));
  }

  public int romanToInt(String A) {
    List<String> romans = new ArrayList<String>();
    romans.add("M");
    romans.add("CM");
    romans.add("D");
    romans.add("CD");
    romans.add("C");
    romans.add("XC");
    romans.add("L");
    romans.add("XL");
    romans.add("X");
    romans.add("IX");
    romans.add("IV");
    romans.add("I");
    romans.add("V");




    Map<String,Integer> map = new HashMap();
    map.put("X",10);
    map.put("IX",9);
    map.put("I",1);
    map.put("IV",4);
    map.put("V",5);
    map.put("XL",40);
    map.put("L",50);
    map.put("XC",90);
    map.put("C",100);
    map.put("CD",400);
    map.put("D",500);
    map.put("CM",900);
    map.put("M",1000);


    String num =A;
    int number=0;
    while(num.length()>0){
      int i=0;
      while(i<romans.size()){
        String roman = romans.get(i);
        if(num.startsWith(roman)){
          number = number+ map.get(roman);
          num = num.substring(roman.length());
          break;
        }
        i++;
      }
    }
    return number;
  }

}
