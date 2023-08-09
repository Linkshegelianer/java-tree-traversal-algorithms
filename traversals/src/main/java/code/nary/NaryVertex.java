package code.nary;

import code.Vertex;
import java.util.List;

public class NaryVertex<T> extends Vertex<T> {

    public List<NaryVertex<T>> children;

    public NaryVertex() {}

    public NaryVertex(T data) {
        super(data);
    }

    public NaryVertex(T data, List<NaryVertex<T>> children) {
        super(data);
        this.children = children;
    }

    boolean processed;
}
