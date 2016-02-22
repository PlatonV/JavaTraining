/**
 * Created by plato on 2/22/2016.
 */
public class BST {

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public void add(int value) {
        BSTNode current = root;

        if (root == null) {
            root = new BSTNode(value);
        } else {
            while (true) {
                if (value < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(new BSTNode(value));
                        return;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(new BSTNode(value));
                        return;
                    }
                    current = current.getRight();
                }
            }
        }
    }

    public boolean remove(int value) {
        BSTNode parent = null;
        BSTNode node = root;
        boolean isLeftChild = false;

        while (node.getValue() != value) {
            parent = node;
            if (value < node.getValue()) {
                isLeftChild = true;
                node = node.getLeft();
            } else {
                isLeftChild = false;
                node = node.getRight();
            }
            if (node == null) {
                return false;
            }
        }
        if (node.getLeft() == null && node.getRight() == null) {
            if (parent == null) {
                root = null;
                return true;
            }
            if (isLeftChild == true) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }
        else if ((node.getLeft() == null && node.getRight() != null) ||
                (node.getLeft() != null && node.getRight() == null)) {
            if (parent == null) {
                if (isLeftChild == true) {
                    root = node.getLeft();
                } else {
                    root = node.getRight();
                }
                return true;
            }
            if (isLeftChild == true) {
                if (node.getLeft() != null) {
                    parent.setLeft(node.getLeft());
                } else {
                    parent.setLeft(node.getRight());
                }
            } else {
                if (node.getLeft() != null) {
                    parent.setRight(node.getLeft());
                } else {
                    parent.setRight(node.getRight());
                }
            }
            return true;
        } else {
            BSTNode successor = getSuccessor(node);
            if (parent == null) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(node.getLeft());
            return true;
        }
    }

    public void traverse() {
        infix(this.root);
    }

    private void infix(BSTNode node) {
        if (node.getLeft() != null) {
            infix(node.getLeft());
        }
        System.out.println(node.getValue());
        if (node.getRight() != null) {
            infix(node.getRight());
        }
    }

    public BSTNode getSuccessor(BSTNode delNode) {
        BSTNode successsor = null;
        BSTNode successsorParent = null;
        BSTNode current = delNode.getRight();
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.getLeft();
        }
        if (successsor != delNode.getRight()) {
            successsorParent.setLeft(successsor.getRight());
            successsor.setRight(delNode.getRight());
        }
        return successsor;
    }
}
