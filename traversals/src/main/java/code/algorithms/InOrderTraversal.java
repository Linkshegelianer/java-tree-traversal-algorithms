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
    public List<T> traverse(NaryVertex<T> root) {
        LinkedList<T> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<NaryVertex<T>> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            NaryVertex<T> current = stack.pollLast();

            result.addFirst(current.data);

            if (current.children != null) {
                for (NaryVertex<T> child : current.children) {
                    stack.add(child);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) { // for test
        NaryVertex<Integer> v1 = new NaryVertex<>(1);
        NaryVertex<Integer> v2 = new NaryVertex<>(2);
        NaryVertex<Integer> v3 = new NaryVertex<>(3);
        NaryVertex<Integer> v4 = new NaryVertex<>(4);
        NaryVertex<Integer> v5 = new NaryVertex<>(5);
        NaryVertex<Integer> v6 = new NaryVertex<>(6);

        // Create the tree structure
        v1.children = Arrays.asList(v3, v2, v4);
        v3.children = Arrays.asList(v5, v6);

        InOrderTraversal<Integer> traversal = new InOrderTraversal<>();
        List<Integer> result = traversal.traverse(v1);
        System.out.println(result); // must be [1, 3, 5, 6, 2, 4]
    }
}
