class LRUCache {
    class Node {
        int key = 0;
        int value = 0;
        Node prev;
        Node next;
    }

    private Node head, tail;
    private int capacity = 0;
    private Map<Integer, Node> map = new HashMap<>();

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
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToFront(node);
            node.value = value;
        }else{
            Node node = new Node();
            node.key = key;
            node.value = value;
            add(node);
            map.put(key, node);
            if(map.size() > capacity) {
                Node poppedTail = popTail();
                map.remove(poppedTail.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */