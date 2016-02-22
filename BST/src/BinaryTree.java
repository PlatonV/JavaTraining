/**
 * Created by plato on 2/22/2016.
 */

public class BinaryTree {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.add(1);
        bst.add(8);
        bst.add(7);
        bst.add(10);
        bst.remove(8);
        bst.traverse();
    }
}
