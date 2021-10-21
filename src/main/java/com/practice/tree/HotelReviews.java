package com.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Review {

  String review;
  int goodWord;
  int index;

  public Review(String review, int goodWord, int index) {
    this.review = review;
    this.goodWord = goodWord;
    this.index = index;
  }
}
public class HotelReviews {


  public ArrayList<Integer> solve(String A, ArrayList<String> B) {
    Set<String> goodWords = new HashSet<>();
    String[] words = A.split("_");
    goodWords.addAll(Arrays.asList(words));
    List<Review> list = new ArrayList<>();

    for(int i=0; i<B.size(); i++){
      list.add(getReview(goodWords,B.get(i),i));
    }
    Collections.sort(list, (r1,r2)-> {
      return r1.goodWord - r2.goodWord;
    });
    ArrayList<Integer> result = new ArrayList<>();
    list.forEach(r->{
      result.add(r.index);
    });
    return result;
  }

  private Review getReview(Set<String> set, String sentence, int index){
    int count = 0;
    String[] words = sentence.split("_");
    for(int i=0;i<words.length;i++){
      if(set.contains(words[i])){
        count++;
      }
    }
    return new Review(sentence,count,index);
  }


}
