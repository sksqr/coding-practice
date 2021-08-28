package com.practice.tree;

public class SortedArrayToBalancedBST {

  public static void main(String[] args) {
    int[] a = {1,2,3};
    TreeNode root = sortedArrayToBST(a);
    System.out.println(root);
  }

  public static TreeNode sortedArrayToBST(final int[] A) {
    return toBST(A,0,A.length-1);
  }



  private static TreeNode toBST(final int[] A, int low, int high) {
    if(low>high){
      return null;
    }
    int mid = (low+high)/2;
    TreeNode root = new TreeNode(A[mid]);
    TreeNode left = toBST(A,low,mid-1);
    TreeNode right = toBST(A,mid+1,high);
    root.left=left;
    root.right=right;
    return root;
  }

}
