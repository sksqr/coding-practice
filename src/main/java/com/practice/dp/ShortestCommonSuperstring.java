package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestCommonSuperstring {

  static String str;


  // Function to calculate the maximum overlap in two given strings
  private static int findOverlappingPair(String s1, String s2, StringBuilder sb)
  {
    // `max` will store the maximum overlap, i.e., the maximum length
    // of the matching prefix and suffix
    int max = Integer.MIN_VALUE;

    // consider minimum length
    int n = Integer.min(s1.length(), s2.length());

    // check if the suffix of `s1` matches with the prefix of `s2`
    for (int i = 1; i <= n; i++)
    {
      // compare the last `i` characters in `s1` with the first `i`
      // characters in `s2`
      if (s1.substring(s1.length() - i).equals(s2.substring(0, i)))
      {
        if (max < i)
        {
          // update `max` and `str`
          max = i;
          sb.setLength(0);
          sb.append(s1).append(s2.substring(i));
        }
      }
    }

    // check if the prefix of `s1` matches with the suffix of `s2`
    for (int i = 1; i <= n; i++)
    {
      // compare the first `i` characters in `s1` with the last `i`
      // characters in `s2`
      if (s1.substring(0, i).equals(s2.substring(s2.length() - i)))
      {
        if (max < i)
        {
          // update `max` and `str`
          max = i;
          sb.setLength(0);
          sb.append(s2).append(s1.substring(i));
        }
      }
    }

    return max;
  }

  // Function to calculate the smallest string that contains
  // each string in a given set as a substring
  public static String findShortestSuperstring(String[] A)
  {
    int n = A.length;

    // run `n-1` times to consider every pair
    while (n != 1)
    {
      // to keep track of the maximum overlap
      int max = Integer.MIN_VALUE;

      // stores index of strings involved in the maximum overlap
      int p = -1, q = -1;

      // keep track of the resultant string after maximum overlap
      String res_str = "";

      for (int i = 0; i < n; i++)
      {
        for (int j = i + 1; j < n; j++)
        {
          StringBuilder sb = new StringBuilder();

          // `r` will store the maximum length of the matching prefix,
          // and suffix `sb` will store the resultant string after
          // maximum overlap of `A[i]` and `A[j]` if any
          int r = findOverlappingPair(A[i], A[j], sb);

          // check for the maximum overlap
          if (max < r)
          {
            max = r;
            res_str = sb.toString();
            p = i;
            q = j;
          }
        }
      }

      // ignore the last element in the next cycle
      n--;

      // if there is no overlap, append the value of `A[n]` to `A[0]`
      if (max == Integer.MIN_VALUE) {
        A[0] = A[0] + A[n];
      }
      else {
        // copy the resultant string to index `p`
        A[p] = res_str;

        // copy the string at last index to index `q`
        A[q] = A[n];
      }
    }

    return A[0];
  }

  // The shortest superstring problem
  public static void main(String[] args)
  {
//    String[] words = { "CATGC", "CTAAGT", "GCTA", "TTCA", "ATGCATC" };
    List<String> list = Arrays.asList("abcd", "cdef", "fgh", "de");
    String[] words = list.toArray(new String[list.size()]);
    System.out.println("The shortest superstring is "
        + findShortestSuperstring(words).length());
  }

//  public static void main(String[] args) {
//    List<String> list = Arrays.asList("abcd", "cdef", "fgh", "de");//( "bcd", "ab", "cd"); //("aaaa", "aa"); //
////    List<String> list = Arrays.asList( "qfgxmuvgfaj", "lfvenhyuhuor", "osamibdnj", "beyhkbso");
////    ShortestCommonSuperstring shortestCommonSuperstring = new ShortestCommonSuperstring();
////    System.out.println(shortestCommonSuperstring.solve(new ArrayList<>(list)));
//
//    System.out.println(findShortestSuperstring(new ArrayList<>(list),list.size()).length());
//  }

  public int solve(ArrayList<String> A) {
    String superSrt = getSuperString(A,0);
    System.out.println(superSrt);
    return superSrt.length();

  }


  public String getSuperString(ArrayList<String> A, int i) {
    if(i==A.size()){
      return "";
    }
    String str = A.get(i);
    String subSuper = getSuperString(A,i+1);
    if(subSuper.contains(str)){
      return subSuper;
    }
    if(str.contains(subSuper)){
      return str;
    }
    int overlap1=0;
    int index1=0;
    for(int j=1; j< str.length(); j++){
      if(subSuper.endsWith(str.substring(0,j))){
        overlap1++;
        index1=j;
        break;
      }
    }
    int overlap2=-0;
    int index2=0;
    for(int j=str.length()-1; j>=0 ; j--){
      if(subSuper.startsWith(str.substring(j,str.length()))){
        overlap2=str.length()-j;
        index2=j;
        break;
      }
    }
    if(overlap1==0 && overlap2==0){
      subSuper = str+subSuper;
    }
    else if(overlap2>overlap1){
      subSuper = str.substring(0,index2)+subSuper;
    }
    else if(overlap2<overlap1){
      subSuper = subSuper+str.substring(index1,str.length());
    }
    else{
      subSuper = subSuper+str.substring(overlap2,str.length());
    }
    return subSuper;

  }



  // Function to calculate maximum
  // overlap in two given strings
  static int findOverlappingPair(String str1,
      String str2)
  {

    // max will store maximum
    // overlap i.e maximum
    // length of the matching
    // prefix and suffix
    int max = Integer.MIN_VALUE;
    int len1 = str1.length();
    int len2 = str2.length();

    // check suffix of str1 matches
    // with prefix of str2
    for (int i = 1; i <=
        Math.min(len1, len2); i++)
    {

      // compare last i characters
      // in str1 with first i
      // characters in str2
      if (str1.substring(len1 - i).compareTo(
          str2.substring(0, i)) == 0)
      {
        if (max < i)
        {

          // Update max and str
          max = i;
          str = str1 + str2.substring(i);
        }
      }
    }

    // check prefix of str1 matches
    // with suffix of str2
    for (int i = 1; i <=
        Math.min(len1, len2); i++)
    {

      // compare first i characters
      // in str1 with last i
      // characters in str2
      if (str1.substring(0, i).compareTo(
          str2.substring(len2 - i)) == 0)
      {
        if (max < i)
        {
          // pdate max and str
          max = i;
          str = str2 + str1.substring(i);
        }
      }
    }
    return max;
  }


  // Function to calculate smallest
  // string that contains
  // each string in the given set as substring.
  static String findShortestSuperstring(
      ArrayList<String> arr, int len)
  {

    // run len-1 times to consider every pair
    while (len != 1)
    {

      // To store maximum overlap
      int max = Integer.MIN_VALUE;

      // To store array index of strings
      // involved in maximum overlap
      int l = 0, r = 0;

      // to store resultant string after
      // maximum overlap
      String resStr = "";

      for (int i = 0; i < len; i++)
      {
        for (int j = i + 1; j < len; j++)
        {

          // res will store maximum
          // length of the matching
          // prefix and suffix str is
          // passed by reference and
          // will store the resultant
          // string after maximum
          // overlap of arr[i] and arr[j],
          // if any.
          int res = findOverlappingPair
              (arr.get(i), arr.get(j));

          // Check for maximum overlap
          if (max < res)
          {
            max = res;
            resStr = str;
            l = i;
            r = j;
          }
        }
      }

      // Ignore last element in next cycle
      len--;

      // If no overlap,
      // append arr[len] to arr[0]
      if (max == Integer.MIN_VALUE)
        arr.set(0, arr.get(0)+arr.get(len));
      else
      {

        // Copy resultant string
        // to index l
        arr.set(l,resStr);

        // Copy string at last index
        // to index r
        arr.set(r, arr.get(len));
      }
    }
    return arr.get(0);
  }

}
