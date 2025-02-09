struct Node {
    Node* next;
    Node* prev;
    int key;
    int val; 
    Node(int key, int val) : key(key), val(val), next(nullptr), prev(nullptr) {}   
};
class LRUCache {
private:


    Node *head = new Node(-1, -1);
    Node *tail = new Node(-1, -1);
    int size = 0;
    unordered_map<int, Node*> cache;

    void add(Node* node) {
        head->next->prev = node;
        node->next = head->next;
        node->prev = head;
        head->next = node;
    }

    void remove(Node* node) {


        Node* prevNode = node->prev;
        Node* nextNode = node->next;
        prevNode->next = nextNode;
        nextNode->prev = prevNode;
    }

    void moveToFront(Node* node) {
        remove(node);
        add(node);
    }

    Node* popTail() {
        Node* poppedTail = tail->prev;
        remove(tail->prev);
        return poppedTail;
    }
public:
    LRUCache(int capacity) {
        head->next = tail;
        tail->prev = head;
        size = capacity;
    }
    
    int get(int key) {
        if(cache.find(key) == cache.end()) return -1;
        Node* node = cache[key];
        moveToFront(node);
        return node->val;
    }
    
    void put(int key, int value) {
        if(cache.find(key) != cache.end()) {
            Node* node = cache[key];
            moveToFront(node);
            node->val = value;
        }else {
            Node *node = new Node(key, value);
            cache[key] = node;
            add(node);
            if(cache.size() > size) {
                Node* poppedTail = popTail();
                cache.erase(poppedTail->key);
            }
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */