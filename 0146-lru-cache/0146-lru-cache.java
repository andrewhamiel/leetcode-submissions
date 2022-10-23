class LRUCache {
    int capacity = 0;
    Map<Integer, Node> map;
    Node tail;
    Node head;
    
    public LRUCache(int capacity) {
        map = new HashMap();
        tail = new Node();
        head = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            add(node);
            
            if(map.size() > capacity){
                Node tailKey = popTail();               
                map.remove(tailKey.key);
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
    
    private void add(Node node){
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    private void moveToHead(Node node){
        remove(node);
        add(node);
    }
    
    private Node popTail() {
    /**
     * Pop the current tail.
     */
    Node res = tail.prev;
    remove(res);
    return res;
  }
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */