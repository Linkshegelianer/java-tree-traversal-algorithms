/*
    Pre-order traversal goes from top to the bottom, from left to right.
    The tree structure in this example:
         1
       / | \
      3  2  4
     / \
    5  6
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

    public static void main(String[] args) {
        NaryVertex<Integer> v1 = new NaryVertex<>(1);
        NaryVertex<Integer> v2 = new NaryVertex<>(2);
        NaryVertex<Integer> v3 = new NaryVertex<>(3);
        NaryVertex<Integer> v4 = new NaryVertex<>(4);
        NaryVertex<Integer> v5 = new NaryVertex<>(5);
        NaryVertex<Integer> v6 = new NaryVertex<>(6);

        // Create the tree structure
        v1.children = Arrays.asList(v3, v2, v4);
        v3.children = Arrays.asList(v5, v6);

        PreOrderNaryTraversal<Integer> traversal = new PreOrderNaryTraversal<>();
        List<Integer> result = traversal.traverse(v1);
        System.out.println(result); // must be [1, 3, 5, 6, 2, 4]
    }

}
