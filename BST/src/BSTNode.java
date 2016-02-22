/**
 * Created by plato on 2/22/2016.
 */
public class BSTNode {

    private int value;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
