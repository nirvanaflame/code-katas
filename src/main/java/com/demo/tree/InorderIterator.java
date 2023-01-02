package com.demo.tree;

public class InorderIterator {
    public InorderIterator(BinaryTreeNode root) {
    }

    public void populateIterator(BinaryTreeNode root) {

    }

    public boolean hasNext() {
        return false;
    }

    public BinaryTreeNode getNext() {
        return null;
    }

    public String inorderUsingIterator(BinaryTreeNode root) {
        InorderIterator iter = new InorderIterator(root);
        StringBuilder result = new StringBuilder();
        while (iter.hasNext()) {
            result.append(iter.getNext().data).append(" ");
        }
        return result.toString();
    }
}
