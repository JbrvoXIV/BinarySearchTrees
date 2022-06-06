
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

    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node curNode, int data) {
        if(curNode == null) {
            return false;
        }

        if(curNode.data == data) {
            return true;
        } else if(curNode.data <= data) {
            return searchRecursive(curNode.right, data);
        } else if(curNode.data > data) {
            return searchRecursive(curNode.left, data);
        }
        return false;
    }

    public boolean remove(int data) {
        return removeRecursive(root, null, data);
    }

    private boolean removeRecursive(Node curNode, Node sucNode, int data) {
        if(curNode == null) {
            return false;
        }

        if(curNode.data == data) {
            if(curNode.left == null && curNode.right == null) { // Remove leaf node
                if(sucNode == null) {
                    root = null;
                } else if(sucNode.left == curNode) {
                    sucNode.left = null;
                } else {
                    sucNode.right = null;
                }
            } else if(curNode.right == null) { // Remove node with one child pt. 1
                if(sucNode == null) {
                    root = curNode.left;
                } else if(sucNode.right == curNode) {
                    sucNode.right = curNode.left;
                } else {
                    sucNode.left = curNode.left;
                }
            } else if(curNode.left == null) { // Remove node with one child pt. 2
                if(sucNode == null) {
                    root = curNode.right;
                } else if(sucNode.right == curNode) {
                    sucNode.right = curNode.right;
                } else {
                    sucNode.left = curNode.right;
                }
            } else { // Remove node with two children
                Node temp = findMinNode(curNode.right); // Recursively find smallest node of right subtree
                if(sucNode == null) {
                    root.right = temp;
                }
                removeRecursive(curNode.right, curNode, temp.data); // Recursively remove smallest node of right subtree
                curNode.data = temp.data;
            }
            return true;
        } else if(data >= curNode.data) { // Move down right
            return removeRecursive(curNode.right, curNode, data);
        } else { // Move down left
            return removeRecursive(curNode.left, curNode, data);
        }
    }

    private Node findMinNode(Node curNode) { // Recursive helper method to find smallest left node of right subtree
        if(curNode.left == null) {
            return curNode;
        }
        return findMinNode(curNode.left);
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if(node == null) {
            return;
        }
        printInOrderRecursive(node.left);
        System.out.printf("%-4d", node.data);
        printInOrderRecursive(node.right);
    }

    public int getParent(int data) {
        return getParentRecursive(root, null, data);
    }

    private int getParentRecursive(Node curNode, Node parNode, int data) {
        if(curNode == null) {
            return -1;
        }

        if(curNode.data == data) {
            if(parNode == null) {
                return -1;
            }
            return parNode.data;
        } else if(data > curNode.data) {
            return getParentRecursive(curNode.right, curNode, data);
        } else {
            return getParentRecursive(curNode.left, curNode, data);
        }
    }
}