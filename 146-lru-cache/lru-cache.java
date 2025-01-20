class LRUCache {
    private Node head, tail;
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity = 0;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    private void moveToFront(Node node) {
        remove(node);
        add(node);
    }

    private Node popTail() {
        Node poppedTail = tail.prev;
        remove(poppedTail);
        return poppedTail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        }else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            add(node);
            map.put(key, node);
            if(map.size() > capacity) {
                Node poppedTail = popTail();
                map.remove(poppedTail.key);
            }
        }
    }

    class Node {
        Node next;
        Node prev;
        int key = 0;
        int val = 0;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */