package code.nary;

import code.nary.NaryVertex;

import java.util.List;

public interface NaryTraversal<T> {

    List<T> traverse(NaryVertex<T> root);
}
