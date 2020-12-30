package com.jeff.leetcode.recrusion;


import com.jeff.leetcode.structrue.TreeNode;

public class Problem104_MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Problem104_MaximumDepthOfBinaryTree problem104_maximumDepthOfBinaryTree = new Problem104_MaximumDepthOfBinaryTree();
        System.out.println(problem104_maximumDepthOfBinaryTree.maxDepth(
                new TreeNode(3,
                        new TreeNode(9, null, null),
                        new TreeNode(20,
                                new TreeNode(15, null, null),
                                new TreeNode(7, null, null)
                        )
                )
            )
        );
    }
}
