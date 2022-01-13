package com.practice.strings;

public class CountAndSay {

  public static void main(String[] args) {
    CountAndSay countAndSay = new CountAndSay();
    System.out.println(countAndSay.countAndSay(5));
  }

  public String countAndSay(int A) {
    String seq="1";
    int divisor=2;
    for(int i=2; i<=A; i++){
      StringBuilder sb = new StringBuilder();
        int j=0;
        while(j<seq.length()){
          int count=1;
          char c = seq.charAt(j);
          j++;
          while(j<seq.length() && seq.charAt(j)==c){
            count++;
            j++;
          }
          sb.append(count);
          sb.append(c);
        }
      seq = sb.toString();

    }
    return seq;
  }

}
