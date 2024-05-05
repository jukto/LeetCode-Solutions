//  Problem: https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }
    
    // To find the last added element, remove all but one elements from the top of q1.
    // The last remaining element is the most recently added, remove and return it.
    // Then put the rest of the elements back.
    public int pop() {
        while (q1.size() > 1) { q2.add(q1.poll()); }

        int r = q1.poll();

        while (!q2.isEmpty()) { q1.add(q2.poll()); }

        return r;
    }
    
    // The same as pop(), except the most recently added value is put back into q1 afterwards.
    public int top() {
        int r = pop();
        q1.add(r);
        return r;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
