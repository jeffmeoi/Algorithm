package com.jeff.leetcode.tree;

import com.jeff.leetcode.structrue.TreeNode;

import java.util.LinkedList;

public class Problem230_KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(--k == 0)
                return node.val;
            node = node.right;
        }
    }

    public static void main(String[] args) {
        Problem230_KthSmallestElementInABST p = new Problem230_KthSmallestElementInABST();
        System.out.println(p.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));
    }
}
