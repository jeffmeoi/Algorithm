package com.jeff.leetcode.tree;

import com.jeff.leetcode.structrue.TreeNode;

public class Problem235_LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while (true) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }

}
