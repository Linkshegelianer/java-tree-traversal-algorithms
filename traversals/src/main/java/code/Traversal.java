package code;

import java.util.List;

public interface Traversal<T> {

    List<T> traverse(NaryVertex<T> root);

    List<T> traverse(BinaryVertex<T> root);
}
