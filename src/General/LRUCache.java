package General;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoublyLinkedList {

        int key;
        int val;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        public DoublyLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DoublyLinkedList() {
        }

    }

    // Add Node next to Head
    public DoublyLinkedList addNextToHead(DoublyLinkedList node) {
        DoublyLinkedList nodeNextToHead = head.next;
        node.next = nodeNextToHead;
        nodeNextToHead.prev = node;
        head.next = node;
        node.prev = head;
        return node;
    }

    // Get Node and move next to head
    public DoublyLinkedList detachAndMoveNextToHead(DoublyLinkedList node) {
        DoublyLinkedList prevNode = node.prev;
        DoublyLinkedList nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return addNextToHead(node);
    }

    // Remove node before tail
    public DoublyLinkedList removeNode() {
        DoublyLinkedList lastNode = tail.prev;
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
        return lastNode;
    }

    int capacity;
    int count = 0;
    DoublyLinkedList head;
    DoublyLinkedList tail;
    Map<Integer, DoublyLinkedList> map;

    public LRUCache(int capacity) {

        map = new HashMap<>();
        this.capacity = capacity;
        head = new DoublyLinkedList();
        tail = new DoublyLinkedList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedList node = map.get(key);
            node = detachAndMoveNextToHead(node);
            map.put(key, node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        // If value is present update the node
        if (map.containsKey(key)) {
            DoublyLinkedList node = map.get(key);
            node.val = value;
            node = detachAndMoveNextToHead(node);
            map.put(key, node);
        }
        // Insert key and node if not present
        else {
            DoublyLinkedList node = addNextToHead(new DoublyLinkedList(key, value));
            map.put(key, node);
            count++;
            map.put(key, node);
            if (count > capacity) {
                DoublyLinkedList deletedNode = removeNode();
                map.remove(deletedNode.key);
                count--;
            }
        }

    }
}
