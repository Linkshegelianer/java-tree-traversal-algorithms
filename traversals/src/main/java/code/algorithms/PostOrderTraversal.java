package code.algorithms;

import code.BinaryVertex;
import code.NaryVertex;
import code.Traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal<T> implements Traversal<T> {

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

    @Override
    public List<T> traverse(NaryVertex<T> root) {
        LinkedList<T> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<NaryVertex<T>> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            NaryVertex<T> vertex = stack.pollLast();
            result.addFirst(vertex.data);
            if (vertex.children != null) {
                for (NaryVertex<T> child : vertex.children) {
                    stack.add(child);
                }
            }
        }

        return result;
    }
}
