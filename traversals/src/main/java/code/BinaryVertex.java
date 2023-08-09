package code;

public class BinaryVertex<T> extends Vertex<T> {

    public BinaryVertex<T> right;

    public BinaryVertex<T> left;

    public BinaryVertex() {}

    public BinaryVertex(T data) {
        super(data);
    }

    public BinaryVertex(T data, BinaryVertex<T> right, BinaryVertex<T> left) {
        super(data);
        this.right = right;
        this.left = left;
    }
}
