package org;


//https://www.baeldung.com/java-binary-tree
//https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
public class BinaryTree {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    //Inserting elements
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public Node addIterative(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(value);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(value);
                    break;
                }
            }
        }
        return root;
    }


    private boolean findRecursive(Node current, int value) {
        if (current == null) return false;
        if (value == current.value) return true;

        if (value < current.value) {
            return findRecursive(current.left, value);
        }
        return findRecursive(current.right, value);
    }

    private Node findNodeRecursive(Node current, int value) {
        if (current == null) return null;
        if (value == current.value) return current;

        if (value < current.value) {
            return findNodeRecursive(current.left, value);
        }
        return findNodeRecursive(current.right, value);
    }


}
