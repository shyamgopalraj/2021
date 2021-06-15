package General;

public class DesignDoublyLinkedList {

    class DoublyLinkedList {

        int val;
        DoublyLinkedList prev;
        DoublyLinkedList next;

        public DoublyLinkedList() {

        }

        public DoublyLinkedList(int val) {
            this.val = val;
        }

    }

    DoublyLinkedList head;

    /** Initialize your data structure here. */
    public DesignDoublyLinkedList() {
        head = null;
    }

    public DoublyLinkedList getNode(int index) {
        if (head == null)
            return null;

        DoublyLinkedList cur = head;

        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        return cur;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        DoublyLinkedList node = getNode(index);
        return node == null ? -1 : node.val;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {

        if (head == null)
            head = new DoublyLinkedList(val);
        else {
            DoublyLinkedList cur = new DoublyLinkedList(val);
            cur.next = head;
            head.prev = cur;
            head = cur;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        if (head == null)
            head = new DoublyLinkedList(val);
        else {
            DoublyLinkedList cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            DoublyLinkedList node = new DoublyLinkedList(val);
            cur.next = node;
            node.prev = cur;
        }

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
     * be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index == 0)
            addAtHead(val);
        else {
            DoublyLinkedList prevNode = getNode(index - 1);
            if (prevNode != null) {
                DoublyLinkedList cur = new DoublyLinkedList(val);
                cur.prev = prevNode;
                cur.next = prevNode.next;
                if (prevNode.next != null) {
                    prevNode.next.prev = cur;
                }
                prevNode.next = cur;
            }

        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        DoublyLinkedList node = getNode(index);
        if (node != null) {
            if (index == 0) {
                head = node.next;
            } else {
                DoublyLinkedList prevNode = node.prev;
                DoublyLinkedList nextNode = node.next;
                prevNode.next = nextNode;
                if (nextNode != null)
                    nextNode.prev = prevNode;
            }
        }
    }

}
