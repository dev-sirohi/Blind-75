class LFUCache {
    private class DLL {
        int key, value, counter;
        DLL pre, post;
    }

    // Always add next to the head
    private void add(DLL node) {
        DLL fhead = head;
        
        while (fhead.post.counter > node.counter) {
            fhead = fhead.post;
        }

        node.pre = fhead;
        node.post = fhead.post;
        fhead.post.pre = node;
        fhead.post = node;
    }

    private void remove(DLL node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private HashMap<Integer, DLL> cache = new HashMap<>();
    private int capacity;
    private int count;
    private DLL head, tail;

    public LFUCache(int capacity) {
        head = new DLL();
        head.pre = null;
        tail = new DLL();
        tail.post = null;
        head.post = tail;
        tail.pre = head;

        this.capacity = capacity;
        count = 0;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            cache.get(key).counter++;
            this.remove(cache.get(key));
            this.add(cache.get(key));
            return cache.get(key).value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLL node = cache.get(key);
            this.remove(node);
            node.value = value;
            node.counter++;
            this.add(node);
        } else {
            count++;
            if (count > capacity) {
                DLL RemNode = tail.pre;
                System.out.println("The one to be removed is: " + RemNode.key);
                tail.pre.pre.post = tail;
                tail.pre = tail.pre.pre;
                cache.remove(RemNode.key);
                count--;
            }

            DLL node = new DLL();
            node.key = key;
            node.value = value;
            node.counter = 1;
            this.add(node);
            cache.put(key, node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
