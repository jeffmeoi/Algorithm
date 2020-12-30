package com.jeff.leetcode.hash;

import java.util.*;

public class Problem146_LRUCache {

    class Node<K, V> {
        public Node<K, V> pre, next;
        public K key;
        public V value;
        public Node(){}
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
        public Node(K key, V value, Node<K,V> pre, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private int capacity;
    private Map<Integer, Node<Integer, Integer>> map = new HashMap<>();
    private Node<Integer, Integer> head, tail;

    public Problem146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    private void deleteNode(Node<Integer, Integer> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(node.key);
    }
    private void addNode(int key, int value) {
        Node<Integer, Integer> node = new Node<>(key, value, head, head.next);
        head.next.pre = node;
        head.next = node;
        map.put(key, node);
    }

    public int get(int key) {
        Node<Integer, Integer> node = map.get(key);
        if(node == null)
            return -1;
        deleteNode(node);
        addNode(key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node = map.get(key);
        if (node != null)
            deleteNode(node);
        addNode(key, value);
        if(map.size() > capacity) {
            deleteNode(tail.pre);
        }
    }

    public static void main(String[] args) {

        Problem146_LRUCache lRUCache = new Problem146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
