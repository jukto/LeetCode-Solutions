class LRUCache {
    private QueueNode[] data;
    private QueueNode head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new QueueNode[10000];
        head = tail = new QueueNode(-1, -1);
        size = 0;
    }
    
    public int get(int key) {
        if (data[key] != null) {
            moveToEndOfQueue(data[key]);
            return data[key].value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (data[key] != null) {
            data[key].value = value;
            moveToEndOfQueue(data[key]);
        } else {
            QueueNode node = new QueueNode(key, value);
            data[key] = node;
            tail.next = node;
            node.previous = tail;
            tail = node;
            size++;
            if (size > capacity) {
                pop();
            }
        }
    }

    private void pop() {
        data[head.next.key] = null;
        head.next = head.next.next;
        if (head.next != null) {
            head.next.previous = head;
        }
    }

    private void moveToEndOfQueue(QueueNode node) {
        if (node.next != null) {
            node.next.previous = node.previous;
            node.previous.next = node.next;
            node.next = null;
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    private class QueueNode {
        public int key, value;
        public QueueNode previous, next;

        public QueueNode(int k, int v) {
            key = k;
            value = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
