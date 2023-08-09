/*
    In-order traversal goes from bottom to the top, from left to right.
 */
package code.nary;

import java.util.*;

public class InOrderNaryTraversal<T> implements NaryTraversal<T> {

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

        InOrderNaryTraversal<Integer> traversal = new InOrderNaryTraversal<>();
        List<Integer> result = traversal.traverse(v1);
        System.out.println(result); // must be [1, 3, 5, 6, 2, 4]
    }
}
