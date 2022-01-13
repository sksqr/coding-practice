package com.practice.facebook;

import com.practice.tree.TreeNode;

public class LastNodeInACompleteBinaryTree {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(5);
        one.left=two;
        one.right=three;
        two.left=four;
        two.right=five;
        three.left=six;


        LastNodeInACompleteBinaryTree obj = new LastNodeInACompleteBinaryTree();
        System.out.println(obj.rightmostDeepestLevel(one));

    }

    public int lastNode(TreeNode A) {
        return depthAndNode(A);
    }

    private int depthAndNode(TreeNode A){
        TreeNode nodeLeft = A;
        int l=0;
        while(nodeLeft.left!=null){
            nodeLeft=nodeLeft.left;
            l++;
        }
        TreeNode nodeRight = A;
        int r=0;
        while(nodeRight.right!=null){
            nodeRight=nodeRight.right;
            r++;
        }
        if(l==r){
            return nodeRight.val;
        }
        return depthAndNode(A.left);
    }

    int rightmostDeepestLevel(TreeNode root){

        int height=0;
        int ans=0;

        TreeNode tmp=root;
        while(tmp!=null){height++;tmp=tmp.left;}

        int low=0;
        int high=(1<<(height-1))-1;
        while(low<=high){
            int mid=(low+high)/2;

            tmp=root;
            for(int h=0;h<height-1;h++){
                if( ((mid >> (height-h-2))&1) >0)
                    tmp=tmp.right;
                else tmp=tmp.left;
            }

            if(tmp!=null){ans=tmp.val;low=mid+1;}
            else high=mid-1;
        }
        return ans;
    }
}
