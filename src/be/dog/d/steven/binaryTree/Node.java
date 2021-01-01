package be.dog.d.steven.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * GET THE MAXIMUM LEVEL SUM AND THE LEVEL
     *
     * @param rootNode The root node of the binary tree
     * @return String declaring the maximum level sum and the level where we can find it
     */
    public static String maxSum(Node rootNode) {

        if (rootNode == null) {
            return "There was no root node.";
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        int highestSum = rootNode.data;
        int level = 1;

        while (!queue.isEmpty()) {

            int sum = 0;
            int i = queue.size();

            while (i-- > 0) {

                Node temp = queue.poll();

                sum += temp.data;

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            if (sum > highestSum) {
                level = queue.size() + 1;
                highestSum = sum;
            }
        }

        return "Highest sum is " + highestSum + " at level: " + level;
    }

    /**
     * GET THE MINIMUM LEVEL SUM AND THE LEVEL
     *
     * @param rootNode The root node of the binary tree
     * @return String declaring the minimum level sum and the level where we can find it
     */
    public static String minSum(Node rootNode) {

        if (rootNode == null) {
            return "There was no root node.";
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        int lowestSum = rootNode.data;
        int level = 1;

        while (!queue.isEmpty()) {

            int sum = 0;
            int i = queue.size();

            while (i-- > 0) {

                Node temp = queue.poll();

                sum += temp.data;

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            if (sum < lowestSum) {
                level = queue.size() + 1;
                lowestSum = sum;
            }
        }

        return "Lowest sum is " + lowestSum + " at level: " + level;
    }

    /**
     * INVERSE A BINARY TREE
     *
     * @param rootNode The root node of the binary tree to inverse
     */
    public static void inverseBinaryTree(Node rootNode) {
        Queue<Node> queue = new LinkedList<>();
        if (rootNode != null) {
            queue.add(rootNode);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            Node temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }

    /**
     * MERGE TWO BINARY TREES TOGETHER, EACH NODE IN THE RESULTING TREE BEING THE SUM OF THE NODES OF THE INPUT TREES
     *
     * @param rootNode1 The root node of the first tree
     * @param rootNode2 The root node of the second tree to be merged with the first
     * @return Merged tree
     */
    public static Node sumOfTrees(Node rootNode1, Node rootNode2) {
        if (rootNode1 == null && rootNode2 == null) {
            return null;
        } else if (rootNode1 == null) {
            return rootNode2;
        } else if (rootNode2 == null) {
            return rootNode1;
        } else {
            rootNode1.data += rootNode2.data;
            rootNode1.left = sumOfTrees(rootNode1.left, rootNode2.left);
            rootNode1.right = sumOfTrees(rootNode1.right, rootNode2.right);
            return rootNode1;
        } // T:O(n), S:O(n)
    }

    @Override
    public String toString() {
        String left = getLeft() != null ? "\nLeft child = " + getLeft().data : "";
        String right = getRight() != null ? "\nRight child = " + getRight().data : "";
        return "Current node = " + data + left + right;
    }
}
