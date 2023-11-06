class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int value;
    }

    Node head, tail;
    Map<Integer, Node> cache = new HashMap<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void add(Node node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    private void moveToFront(Node node){
        remove(node);
        add(node);
    }

    private Node popTail(){
        Node poppedTail = tail.prev;
        remove(poppedTail);
        return poppedTail;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            Node node = new Node();
            node.key = key;
            node.value = value;
            add(node);
            cache.put(key, node);
            if(cache.size() > capacity){
                Node poppedTail = popTail();
                cache.remove(poppedTail.key);
            }
        }else{
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */