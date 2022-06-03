
public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(30);
        bst.insert(20);
        bst.insert(35);
        bst.insert(24);
        bst.insert(18);
        bst.insert(32);
        bst.printInOrder();

        System.out.println();
        System.out.println(bst.search(32));
        System.out.println(bst.search(20));
        System.out.println(bst.search(30));
        System.out.println(bst.search(99));
    }    
}