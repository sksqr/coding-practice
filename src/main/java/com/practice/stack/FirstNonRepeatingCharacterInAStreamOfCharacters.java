package com.practice.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FirstNonRepeatingCharacterInAStreamOfCharacters {

  public static void main(String[] args) {
//    String A ="abadbc";
//    String A ="abcabc";
    String A = "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl";
    System.out.println("jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyqqqqq".equals(solve(A)));
//

//    String A = "iliilmbxyeukaymfoljtsonuyagzhpbjopclniiu";
//    System.out.println("iill#mmmmmmmmmbbbbbbbbbbbbbbbbxxxxxxxxxx".equals(solve(A)));



  }


  public static String solve(String A) {
    Map<Character,Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();
    StringBuilder b = new StringBuilder();
    int n = A.length();
    for (int i=0;i<n;i++){
      if(map.containsKey(A.charAt(i))){
        map.put(A.charAt(i),2);
      }
      else {
        map.put(A.charAt(i),1);
      }
      queue.add(A.charAt(i));
      boolean append = false;
      while (!append){
        if(!queue.isEmpty()){
          if(map.get(queue.peek())==1){
            b.append(queue.peek());
            append = true;
          }
          else {
            queue.poll();
          }
        }
        else {
          b.append("#");
          append=true;
        }
      }

    }
    System.out.println("Returning: "+b);
    return b.toString();
  }

  private static Character getNonRepeatedFromQueue(Queue<Character> queue, Map<Character, Integer> map) {
    while (!queue.isEmpty()){
      if(map.containsKey(queue.peek()) && map.get(queue.peek()) >1){
        queue.poll();
      }
      else {
        return queue.poll();
      }
    }
    return '#';
  }
}
