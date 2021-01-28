package linkedList;

/**
 *
 * @author shill
 */
public class SinglyLinkedList<E> {

    private int size = 0;
    private Node<E> head;
    

    /**
     * Default constructor
     */
    public SinglyLinkedList() {

    }
    
    /**
     * IntNode class 
     * Nodes for this singly linked list
     * 
     */
    private class Node<E> {
    
    E data;
    Node<E> next;
    
    public Node(E data, Node<E> next){
        
        this.data = data;
        this.next = next;
        
    }
}

    /**
     * Adds a new node in the front of the list with the specified value
     *
     * @param item Item to add in front of list
     */
    public void add(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    /**
     * gets the size of the list
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Finds if a given value exists in the list
     *
     * @param item The item to search for
     * @return Boolean representing if the item exists
     */
    public boolean find(E item) {
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.data == item) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    
}
