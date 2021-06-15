package General;

public class MyLinkedList {

    class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

Node head = null;

/** Initialize your data structure here. */
public MyLinkedList() {

}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
public int get(int index) {

    int currentIndex = 0;

    if (head == null)
        return -1;

    Node cur = head;

    while (cur.next != null && currentIndex != index) {
        cur = cur.next;
        currentIndex++;
    }

    return currentIndex != index ? -1 : cur.val;

}

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
 * the first node of the linked list.
 */
public void addAtHead(int val) {
    Node cur = new Node(val);
    cur.next = head;
    head = cur;
}

/** Append a node of value val to the last element of the linked list. */
public void addAtTail(int val) {

    if (head == null)
        head = new Node(val);

    Node cur = head;
    while (cur.next != null) {
        cur = cur.next;
    }

    cur.next = new Node(val);
}

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
 * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
 * be inserted.
 */
public void addAtIndex(int index, int val) {

    if (index == 0) {
        addAtHead(val);
        return;
    }

    if (head != null) {

        int currentIndex = 0;
        Node prev = head;

        while (prev.next != null && currentIndex != index - 1) {
            prev = prev.next;
            currentIndex++;
        }

        if (currentIndex == index - 1) {
            Node cur = new Node(val);
            if (prev.next == null) {
                prev.next = cur;
            } else {
                cur.next = prev.next;
                prev.next = cur;
            }
        }

    }

}

/** Delete the index-th node in the linked list, if the index is valid. */
public void deleteAtIndex(int index) {
    if (head != null) {
        if (index == 0) {
            head = head.next;
        } else {
            int currentIndex = 0;
            Node prev = head;
            while (prev.next != null && currentIndex != index - 1) {
                prev = prev.next;
                currentIndex++;
            }

            if (currentIndex == index - 1) {
                if (prev.next != null){
                    prev.next = prev.next.next;
                } 
            }

        }
    }
}

    private void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // myLinkedList.addAtHead(1);
        // myLinkedList.display();
        // myLinkedList.addAtTail(3);
        // myLinkedList.display();
        // myLinkedList.addAtIndex(1, 2);
        // myLinkedList.display();
        // myLinkedList.get(1);
        // myLinkedList.display();
        // myLinkedList.deleteAtIndex(1);
        // myLinkedList.display();
        // myLinkedList.get(1);
        // myLinkedList.display();

        myLinkedList.addAtIndex(0, 10);
        myLinkedList.display();
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.display();
        myLinkedList.addAtIndex(1, 30);
        myLinkedList.display();
        myLinkedList.get(0);
        myLinkedList.display();
    }

}
