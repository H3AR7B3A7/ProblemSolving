package be.dog.d.steven.binaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class NodeTest {


    @Test
    void minimum_sum_at_level_test(){
        Node root = createTree();
        assertEquals("Lowest sum is 1 at level: 1",Node.minSum(root));
    }

    @Test
    void maximum_sum_at_level_test(){
        Node root = createTree();
        assertEquals("Highest sum is 17 at level: 3",Node.maxSum(root));
    }

    @Test
    void inverse_binary_tree_test(){
        Node root = createTree();
        Node.inverseBinaryTree(root);
        assertEquals(3, root.getLeft().getData());
        assertEquals(2, root.getRight().getData());
        assertEquals(7, root.getLeft().getLeft().getLeft().getData());
        assertEquals(6, root.getLeft().getLeft().getRight().getData());
        assertNull(root.getLeft().getRight());
    }

    private Node createTree() {
        Node root = new Node(1); //                                      1
        root.setLeft(new Node(2)); //                                  /   \
        root.setRight(new Node(3)); //                                2     3
        root.getLeft().setLeft(new Node(4)); //                      /  \     \
        root.getLeft().setRight(new Node(5)); //                    4    5     8
        root.getRight().setRight(new Node(8)); //                             /  \
        root.getRight().getRight().setLeft(new Node(6)); //                  6    7
        root.getRight().getRight().setRight(new Node(7)); //
        return root;
    }
}