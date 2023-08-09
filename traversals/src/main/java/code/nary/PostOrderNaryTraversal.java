/*
    Postorder traversal goes from left to right, from bottom to the top.
 */
package code.nary;

import java.util.*;

public class PostOrderNaryTraversal<T> implements NaryTraversal<T> {

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
