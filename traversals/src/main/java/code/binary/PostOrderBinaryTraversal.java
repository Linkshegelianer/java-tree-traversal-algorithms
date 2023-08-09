/*
    Postorder traversal goes from left to right, from bottom to the top.
 */
package code.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderBinaryTraversal<T> implements BinaryTraversal<T> {

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
            result.add(0, current.data);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return result;
    }
}
