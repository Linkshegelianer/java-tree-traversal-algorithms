/*
    Pre-order traversal goes from top to the bottom, from left to right.
 */
package code.nary;

import java.util.*;

public class PreOrderNaryTraversal<T> implements NaryTraversal<T> {

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
