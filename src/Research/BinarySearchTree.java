package Research;

/*

 */

public class BinarySearchTree<T extends Comparable> {

    // Search Node for index
    public Node<T> find(Node<T> root, T x) {

        if(root == null)
            return null;
        else if(root.key == x)
            return root;
        else if(root.key.compareTo(x) == 1) {
            return find(root.right, x);
        }
        else {
            return find(root.left, x);
        }
    }

    // Insert new Node
    public Node<T> insert(Node<T> root, T x) {

        if(root==null) {
            Node temp =  new Node<T>();
            temp.key = x;
            return temp;
        } else if(root.key.compareTo(x)==1){
            root.right = insert(root.right, x);
        } else if(root.key.compareTo(x)==-1){
            root.left = insert(root.left, x);
        }

        return root;
    }

}
