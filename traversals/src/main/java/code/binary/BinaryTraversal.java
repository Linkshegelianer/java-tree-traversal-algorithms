package code.binary;

import java.util.List;

public interface BinaryTraversal<T> {

    List<T> traverse(BinaryVertex<T> root);
}
