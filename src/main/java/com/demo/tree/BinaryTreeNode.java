package com.demo.tree;


import java.util.Objects;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    // below data members used only for some problems
    public BinaryTreeNode next;
    public BinaryTreeNode parent;
    public int count;


    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof BinaryTreeNode that)) return false;
        return data == that.data;
    }

    @Override public int hashCode() {
        return Objects.hash(data);
    }
}
