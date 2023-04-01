class LRUCache {
    class DLL {
        int key, val;
        DLL pre, post;
    }

    private void add(DLL node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void remove(DLL node) {
        DLL pre = node.pre;
        DLL post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private HashMap<Integer, DLL> cache = new HashMap<Integer, DLL>();
    private int capacity;
    private int count;
    private DLL head, tail;


    // THIS IS WHERE THE MAIN CODE STARTS


    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;

        head = new DLL();
        tail = new DLL();
        head.pre = null;
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            add(cache.get(key));
            return cache.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            DLL node = new DLL();
            node.key = key;
            node.val = value;

            cache.put(key, node);
            add(node);

            ++count;

            if(count > capacity){
                cache.remove(tail.pre.key);
                tail.pre.pre.post = tail;
                tail.pre = tail.pre.pre;
                --count;
            }
        } else {
            cache.get(key).val = value;
            remove(cache.get(key));
            add(cache.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
