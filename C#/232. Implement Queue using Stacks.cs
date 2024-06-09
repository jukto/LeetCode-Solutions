// Problem: https://leetcode.com/problems/implement-queue-using-stacks/

public class MyQueue {
    private Stack<int> stack1 = [], stack2 = [];
    
    public void Push(int x) {
        while (stack2.Count > 0) {
            stack1.Push(stack2.Pop());
        }

        stack1.Push(x);
    }
    
    public int Pop() {
        while (stack1.Count > 0) {
            stack2.Push(stack1.Pop());
        }

        return stack2.Pop();
    }
    
    public int Peek() {
        while (stack1.Count > 0) {
            stack2.Push(stack1.Pop());
        }

        return stack2.Peek();
    }
    
    public bool Empty() {
        return stack1.Count == stack2.Count;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */
