/*
    Postorder traversal goes from left to right, from bottom to the top.
    The tree structure in this example:
         1
       / | \
      3  2  4
     / \
    5  6
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

        PostOrderNaryTraversal<Integer> traversal = new PostOrderNaryTraversal<>();
        List<Integer> result = traversal.traverse(v1);
        System.out.println(result); // must be [5, 6, 3, 2, 4, 1]
    }
}
