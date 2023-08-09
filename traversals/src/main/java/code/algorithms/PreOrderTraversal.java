package code.algorithms;

import code.BinaryVertex;
import code.NaryVertex;
import code.Traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal<T> implements Traversal<T> {

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

    @Override
    public List<T> traverse(NaryVertex<T> root) {
        List<T> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<NaryVertex<T>> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            NaryVertex<T> current = stack.pollLast();
            result.add(current.data);

            if (current.children != null) {
                for (int i = current.children.size() - 1; i >= 0; i--) {
                    stack.add(current.children.get(i));
                }
            }
        }

        return result;
    }
}
