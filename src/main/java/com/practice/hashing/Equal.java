package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Pair{
  int index1;
  int index2;
  Pair(int i1, int i2){
    index1=i1;
    index2=i2;
  }
}

public class Equal {

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(343, 23, 244, 118, 342, 128, 288, 29, 99, 342, 261, 0, 258, 119, 229, 191, 221, 284, 94, 81, 5, 225, 231, 232, 213, 83, 170, 378, 205, 165, 150, 252, 125, 162, 327, 231, 351, 7, 361, 293, 252, 91, 280, 359, 173, 340, 39, 216, 317, 163, 159, 252, 246, 364, 388, 310, 392, 314, 21, 264, 224, 201, 332, 323, 309, 161, 294, 184, 17, 154, 167, 313, 111, 91, 64, 329, 264, 251, 299, 335, 276, 49, 343, 43, 73, 333, 178, 45, 388, 270, 29, 11, 324, 250, 118, 34, 383, 130, 94, 313, 175, 39, 388, 251, 0, 263, 199, 82, 34, 79, 261, 157, 347, 87, 356, 128, 73, 184, 350, 174, 375, 404, 314, 247, 186, 209, 274, 56, 264, 222, 297, 220, 106, 71, 89, 211, 176, 195, 135, 384, 177, 372, 89, 38, 288, 18, 137, 201, 208, 204, 182, 157, 185, 80, 207, 127, 34, 199, 32, 167, 168, 57, 380, 322, 196, 8, 238, 330, 358, 202, 274, 123, 376, 158, 318, 272, 101, 313, 19, 13, 125, 36, 125, 71, 17, 212, 353, 187, 396, 64, 46, 317, 11, 15, 30, 44, 83, 405, 184, 0, 321, 162, 84, 18, 15, 339, 229, 69, 103, 357, 73, 269, 186, 126, 35, 384, 221, 313, 309, 65, 362, 291, 172, 249, 239, 274, 77, 248, 217, 240, 344, 36, 266, 237, 377, 39, 123, 43, 231, 80, 235, 373, 298, 233, 296, 100, 288, 345, 107, 162, 144, 350, 345, 369, 285, 225, 73, 301, 16, 167, 329, 191, 140, 111, 201, 402, 298, 177, 171, 179, 35, 126, 0, 348, 1, 274, 398, 280, 194, 186, 282, 398, 221, 352, 183, 188, 297, 400, 189, 171, 141, 381, 329, 95, 225, 315, 198, 71, 196, 349, 150, 184, 102, 190, 116, 208, 287, 124, 96, 253, 379, 111, 36, 16, 46, 43, 361, 300, 314, 47, 283, 183, 117, 394, 246, 161, 329, 21, 316, 305, 95, 393, 276, 218, 108, 356, 388, 309, 219, 402, 134, 367, 78, 271, 368, 12, 112, 341, 21, 81, 402, 141, 254, 98, 290, 175, 323, 305, 283, 69, 28, 141, 131, 317, 363, 51, 399, 223, 327, 397, 75, 48, 337, 98, 351, 82, 284, 390, 306, 275, 185, 257, 378, 182, 231, 328, 349, 330, 368, 135, 92, 107, 218, 20, 196, 22, 263, 34, 282, 293, 342, 399, 47, 42, 173, 393, 168, 176, 341, 198, 39, 335, 16, 36, 365, 352, 339, 58, 170, 314, 60, 314, 311, 382, 42, 274, 39, 248, 83, 377, 165, 363, 358, 116, 278, 141, 387, 102, 137, 66, 33, 160, 245, 192, 46, 308, 35, 133, 95, 4, 36, 264, 145, 311, 197, 286, 216, 71, 344, 247, 147, 274, 90, 293, 285, 267, 29, 92, 113, 209, 211, 12, 290, 123, 42, 203, 245, 102, 287, 261, 338, 399, 27, 1, 367, 180, 178, 332, 298, 10, 390, 50, 230, 164, 301, 278, 59, 244, 359, 337, 102, 155, 191, 14, 365, 215, 143, 52, 278, 284, 1, 379, 116, 21, 73, 308, 63, 97, 173, 253, 89, 60, 158, 120, 119, 188, 7, 175, 367, 353, 196, 144, 12, 363, 31, 342, 330, 341, 345, 117, 154, 361, 3, 393, 65, 276, 48, 23, 138, 123, 31, 384, 224, 46, 308, 33, 250, 402, 123, 390, 354, 265, 258, 198, 42, 102, 311, 145, 345, 108, 258, 165, 14, 20, 305, 120, 49, 276, 86, 128, 92, 183, 379, 186, 173, 373, 184, 46, 92, 357, 209, 19, 90, 297, 254, 160, 153, 323, 331, 309, 393, 53, 245, 9, 48, 289, 379, 277, 405, 220, 29, 90, 31, 298, 109, 354, 156, 305, 238, 314, 283, 369, 152, 321, 94, 281, 19, 397, 51, 236, 314, 195, 50, 190, 221, 305, 203, 281, 230, 265, 181, 305, 191, 403, 382, 142, 335, 292, 41, 263, 119, 237, 325, 126, 209, 23, 206, 142, 252, 201, 378, 298, 57, 84, 345, 309, 42, 291, 251, 373, 290, 83, 199, 42, 128, 230, 327, 257, 332, 395, 301, 77, 230, 312, 107, 289, 98, 333, 358, 22, 319, 11, 94, 343, 343, 246, 230, 255, 190, 256, 166, 170, 37, 369, 106, 353, 70, 323, 63, 329, 36, 116, 267, 62, 108, 257, 95, 141, 9, 377, 319, 206, 0, 109, 169, 137, 214, 148, 99, 219, 311, 244, 351, 130, 359, 150, 303, 153, 2, 389, 386, 284, 237, 304, 236, 176, 302, 100, 213, 215, 67, 321, 210, 1, 122, 219, 225, 13, 22, 360, 112, 374, 3, 163, 25, 376, 188, 7, 338, 251, 291, 300, 314, 111, 2, 131, 400, 274, 84, 318, 158, 342, 248, 390, 239, 261, 233, 145, 79, 303, 271, 369, 82, 342, 367, 219, 113, 133, 60, 229, 311, 65, 100, 256, 115, 224, 376, 285, 287, 73, 214, 111
//);

    List<Integer> list = Arrays.asList(1,1,1,1,1,1,1);
    Equal equal = new Equal();
    System.out.println(equal.equalDataWithoutList(new ArrayList<>(list)));
  }

  public ArrayList<Integer> equalDataWithoutList(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> results = new ArrayList();
    HashMap<Integer,Pair>  sumPairsMap = new HashMap();
    int n=A.size();
    Set<Integer> resultSet = new LinkedHashSet();
    for(int i=0;i<n-1;i++){
      for(int j=i+1;j<n;j++){
        int sum= A.get(i)+A.get(j);
        Pair newPair = new Pair(i,j);
        if(sumPairsMap.get(sum)!=null){
          Pair p=sumPairsMap.get(sum);
          {
            ArrayList<Integer>  result = new ArrayList();
            resultSet.clear();
            resultSet.add(p.index1);
            resultSet.add(p.index2);
            resultSet.add(i);
            resultSet.add(j);
            if(resultSet.size()==4){
              result.addAll(resultSet);
              results.add(result);
            }
          }
        }
        else{
          sumPairsMap.put(sum,newPair);
        }
      }

    }
    Collections.sort(results, (l1,l2)->{
      for(int i=0;i<4;i++){
        if(l1.get(i)!=l2.get(i)){
          return l1.get(i) - l2.get(i);
        }
      }
      return 0;
    });
    return results.get(0);
  }


  public ArrayList<Integer> equalData(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> results = new ArrayList();
    HashMap<Integer,List<Pair>>  sumPairsMap = new HashMap();
    int n=A.size();
    Set<Integer> resultSet = new LinkedHashSet();
    for(int i=0;i<n-1;i++){
      for(int j=i+1;j<n;j++){
        int sum= A.get(i)+A.get(j);
        Pair newPair = new Pair(i,j);
        if(sumPairsMap.get(sum)!=null){
          List<Pair> pairList=sumPairsMap.get(sum);
          for(Pair p:pairList){
            ArrayList<Integer>  result = new ArrayList();
            resultSet.clear();
            resultSet.add(p.index1);
            resultSet.add(p.index2);
            resultSet.add(i);
            resultSet.add(j);
            if(resultSet.size()==4){
              result.addAll(resultSet);
              results.add(result);
            }
          }
          pairList.add(newPair);
        }
        else{
          List<Pair> list = new ArrayList();
          list.add(newPair);
          sumPairsMap.put(sum,list);
        }
      }

    }
    Collections.sort(results, (l1,l2)->{
      for(int i=0;i<4;i++){
        if(l1.get(i)!=l2.get(i)){
          return l1.get(i) - l2.get(i);
        }
      }
      return 0;
    });
    return results.get(0);
  }


}
