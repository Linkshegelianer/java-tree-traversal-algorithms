package code;

import code.binary.BinaryVertex;
import code.binary.InOrderBinaryTraversal;
import code.binary.PostOrderBinaryTraversal;
import code.binary.PreOrderBinaryTraversal;
import code.nary.InOrderNaryTraversal;
import code.nary.NaryVertex;

import java.util.Arrays;
import java.util.List;

import code.nary.PostOrderNaryTraversal;
import code.nary.PreOrderNaryTraversal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    InOrderBinaryTraversal<Integer> binaryInOrder;
    PreOrderBinaryTraversal<Integer> binaryPreOrder;
    PostOrderBinaryTraversal<Integer> binaryPostOrder;

    InOrderNaryTraversal<Integer> naryInOrder;
    PostOrderNaryTraversal<Integer> naryPostOrder;
    PreOrderNaryTraversal<Integer> naryPreOrder;

    List<Integer> resultInOrderBinary;
    List<Integer> resultPreOrderBinary;
    List<Integer> resultPostOrderBinary;
    List<Integer> resultInOrderNary;
    List<Integer> resultPreOrderNary;
    List<Integer> resultPostOrderNary;

    @BeforeEach
    void setUp() {
        binaryInOrder = new InOrderBinaryTraversal<>();
        binaryPreOrder = new PreOrderBinaryTraversal<>();
        binaryPostOrder = new PostOrderBinaryTraversal<>();

        naryInOrder = new InOrderNaryTraversal<>();
        naryPostOrder = new PostOrderNaryTraversal<>();
        naryPreOrder = new PreOrderNaryTraversal<>();

        resultInOrderBinary = Arrays.asList(1, 2, 3, 4, 6, 7, 9);
        resultPreOrderBinary = Arrays.asList(4, 2, 1, 3, 7, 6, 9);
        resultPostOrderBinary = Arrays.asList(1, 3, 2, 6, 9, 7, 4);
        resultInOrderNary = Arrays.asList(5, 3, 6, 1, 2, 4); // Corrected result
        resultPreOrderNary = Arrays.asList(1, 3, 5, 6, 2, 4);
        resultPostOrderNary = Arrays.asList(5, 6, 3, 2, 4, 1);
    }

    /*
    Actual tree structure:
          4
       /    \
      2     7
     / \   / \
    1  3  6  9
    */

    public static BinaryVertex<Integer> createBinaryTree() {
        BinaryVertex<Integer> v1 = new BinaryVertex<>(4);
        BinaryVertex<Integer> v2 = new BinaryVertex<>(2);
        BinaryVertex<Integer> v3 = new BinaryVertex<>(7);
        BinaryVertex<Integer> v4 = new BinaryVertex<>(1);
        BinaryVertex<Integer> v5 = new BinaryVertex<>(3);
        BinaryVertex<Integer> v6 = new BinaryVertex<>(6);
        BinaryVertex<Integer> v7 = new BinaryVertex<>(9);

        v1.left = v2;
        v1.right = v3;
        v2.left = v4;
        v2.right = v5;
        v3.left = v6;
        v3.right = v7;

        return v1;
    }

    /*
    Actual tree structure:
         1
       / | \
      3  2  4
     / \
    5  6
     */

    public static NaryVertex<Integer> createNaryTree() {
        NaryVertex<Integer> v1 = new NaryVertex<>(1);
        NaryVertex<Integer> v2 = new NaryVertex<>(2);
        NaryVertex<Integer> v3 = new NaryVertex<>(3);
        NaryVertex<Integer> v4 = new NaryVertex<>(4);
        NaryVertex<Integer> v5 = new NaryVertex<>(5);
        NaryVertex<Integer> v6 = new NaryVertex<>(6);

        v1.children = Arrays.asList(v3, v2, v4);
        v3.children = Arrays.asList(v5, v6);

        return v1;
    }

    @Test
    void testBinary() {
        List<Integer> expectedInOrder = binaryInOrder.traverse(createBinaryTree());
        List<Integer> expectedPreOrder = binaryPreOrder.traverse(createBinaryTree());
        List<Integer> expectedPostOrder = binaryPostOrder.traverse(createBinaryTree());

        assertThat(expectedInOrder).isEqualTo(resultInOrderBinary);
        assertThat(expectedPreOrder).isEqualTo(resultPreOrderBinary);
        assertThat(expectedPostOrder).isEqualTo(resultPostOrderBinary);
    }

    @Test
    void testNary() {
        List<Integer> expectedInOrder = naryInOrder.traverse(createNaryTree());
        List<Integer> expectedPreOrder = naryPreOrder.traverse(createNaryTree());
        List<Integer> expectedPostOrder = naryPostOrder.traverse(createNaryTree());

        assertThat(expectedInOrder).isEqualTo(resultPostOrderNary); // fix
        assertThat(expectedPreOrder).isEqualTo(resultPreOrderNary);
        assertThat(expectedPostOrder).isEqualTo(resultPostOrderNary);
    }
}
