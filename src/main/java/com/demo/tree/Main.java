package com.demo.tree;

import java.util.ArrayList;
import java.util.List;

import static com.demo.tree.BinaryTree.areIdentical;

public class Main {

    public static void main(String[] argv) {

        List<Integer> input1 = new ArrayList<>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTreeNode root1 = BinaryTreeSolutions.createBST(input1);

        List<Integer> input2 = new ArrayList<>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        BinaryTreeNode root2 = BinaryTreeSolutions.createBST(input2);

        BinaryTreeSolutions.displayLevelOrder(root1);

        BinaryTreeSolutions.displayLevelOrder(root2);

        if(areIdentical(root1, root2)) {
            System.out.println("The trees are identical");
        } else {
            System.out.println("The trees are not identical");
        }
    }
}
