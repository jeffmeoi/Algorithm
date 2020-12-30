package com.jeff.leetcode.queue;

import com.jeff.leetcode.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem103_BinaryTreeZigzagLevelOrderTraversal {

    static class Node {
        TreeNode treeNode;
        int layer;

        public Node(TreeNode treeNode, int layer) {
            this.treeNode = treeNode;
            this.layer = layer;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if(front.treeNode == null)
                return res;
            if(res.size() <= front.layer)
                res.add(new LinkedList<>());
            LinkedList<Integer> list = (LinkedList<Integer>) res.get(front.layer);
            if(front.layer % 2 == 0) {
                list.addLast(front.treeNode.val);
            } else {
                list.addFirst(front.treeNode.val);
            }
            if(front.treeNode.left != null)
                queue.offer(new Node(front.treeNode.left, front.layer+1));
            if(front.treeNode.right != null)
                queue.offer(new Node(front.treeNode.right, front.layer+1));
        }
        return res;
    }

    public static void main(String[] args) {
        Problem103_BinaryTreeZigzagLevelOrderTraversal problem103_binaryTreeZigzagLevelOrderTraversal = new Problem103_BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(problem103_binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));
        System.out.println(problem103_binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(null));
    }
}
