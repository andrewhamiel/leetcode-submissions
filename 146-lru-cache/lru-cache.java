class LRUCache {

  class Node {
    Node next;
    Node prev;
    int key;
    int val;
  }

  Node head, tail;
  int capacity;
  Map<Integer, Node> map = new HashMap<>();

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

    private void moveToHead(Node node){
      remove(node);
      add(node);
    }

    private Node popTail(){
        Node res = tail.prev;
        remove(res);
        return res;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.val;      
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
          Node node = map.get(key);
          moveToHead(node);
          node.val = value;
        }else{
          Node node = new Node();
          node.key = key;
          node.val = value;
          add(node);
          map.put(key, node);
          if(map.size() > capacity){
            Node toBeRemoved = popTail();
            map.remove(toBeRemoved.key);
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