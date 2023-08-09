/*
    Pre-order traversal goes from top to the bottom, from left to right.
    The tree structure in this example:
          4
       /    \
      2     7
     / \   / \
    1  3  6  9

 */
package code.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderBinaryTraversal<T> implements BinaryTraversal<T> {
    @Override
    public List<T> traverse(BinaryVertex<T> root) {
        List<T> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<BinaryVertex<T>> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryVertex<T> current = stack.pop();
            result.add(current.data);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryVertex<Integer> v1 = new BinaryVertex<>(4);
        BinaryVertex<Integer> v2 = new BinaryVertex<>(2);
        BinaryVertex<Integer> v3 = new BinaryVertex<>(7);
        BinaryVertex<Integer> v4 = new BinaryVertex<>(1);
        BinaryVertex<Integer> v5 = new BinaryVertex<>(3);
        BinaryVertex<Integer> v6 = new BinaryVertex<>(6);
        BinaryVertex<Integer> v7 = new BinaryVertex<>(9);

        // Create the tree structure
        v1.left = v2;
        v1.right = v3;
        v2.left = v4;
        v2.right = v5;
        v3.left = v6;
        v3.right = v7;

        PreOrderBinaryTraversal<Integer> traversal = new PreOrderBinaryTraversal<>();
        List<Integer> result = traversal.traverse(v1);
        System.out.println(result); // must be [4, 2, 1, 3, 7, 6, 9]
    }
}
