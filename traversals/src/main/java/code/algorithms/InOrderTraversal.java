package code.algorithms;

import code.BinaryVertex;
import code.NaryVertex;
import code.Traversal;

import java.util.*;

public class InOrderTraversal<T> implements Traversal<T> {

    @Override
    public List<T> traverse(BinaryVertex<T> root) {
        List<T> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<BinaryVertex<T>> stack = new LinkedList<>();

        BinaryVertex<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.data);
            current = current.right;
        }

        return result;
    }

    @Override
    public List<T> traverse(NaryVertex<T> node) {
        LinkedList<T> result = new LinkedList<>();
        if (node == null) {
            return result;
        }

        int total = node.childrenArr.length;

        // Traverse all children except the last one
        for (int i = 0; i < total - 1; i++) {
            result.addAll(traverse(node.childrenArr[i]));
        }

        result.add(node.data);

        // Traverse the last child
        if (total > 0) {
            result.addAll(traverse(node.childrenArr[total - 1]));
        }

        return result;
    }
}
