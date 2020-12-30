package com.jeff.leetcode.tree;

import com.jeff.leetcode.structrue.TreeNode;

public class Problem124_BinaryTreeMaximumPathSum {


    private int res = 0;

    public int maxPath(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = Math.max(0, maxPath(root.left));
        int rightDepth = Math.max(0, maxPath(root.right));
        res = Math.max(res, leftDepth + rightDepth + root.val);
        return Math.max(leftDepth, rightDepth) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        res = root.val;
        maxPath(root);
        return res;
    }

    public static void main(String[] args) {
        Problem124_BinaryTreeMaximumPathSum p = new Problem124_BinaryTreeMaximumPathSum();
        System.out.println(p.maxPathSum(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null))));     // 6
        System.out.println(p.maxPathSum(new TreeNode(-10, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));     // 42
    }
}
