
class BinarySearchTree {

    class Node {
        Node right, left;
        int data;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int data) {
        this.root = new Node(data);
    }

    public void insert(int data) {
        insertRecursive(root, data);
    }

    private Node insertRecursive(Node curNode, int data) {
        if(curNode == null) {
            root = new Node(data);
            return root;
        }
        if(curNode.data > data) {
            if(curNode.left == null) {
                curNode.left = new Node(data);
                return curNode.left;
            }
            return insertRecursive(curNode.left, data);
        } else {
            if(curNode.right == null) {
                curNode.right = new Node(data);
                return curNode.right;
            }
            return insertRecursive(curNode.right, data);
        }
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if(node == null) {
            return;
        }
        printInOrderRecursive(node.left);
        System.out.printf("%d, ", node.data);
        printInOrderRecursive(node.right);
    }
}