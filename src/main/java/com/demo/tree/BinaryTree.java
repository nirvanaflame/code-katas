package com.demo.tree;

import java.util.Objects;

public class BinaryTree {

    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(!Objects.equals(root1, root2)) return false;

        var left = areIdentical(root1.left, root2.left);
        var right = areIdentical(root1.right, root2.right);

        return left == right;
    }


}