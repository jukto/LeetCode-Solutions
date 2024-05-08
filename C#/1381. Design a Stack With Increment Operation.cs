// Problem: https://leetcode.com/problems/design-a-stack-with-increment-operation/

public class CustomStack {
    private int[] stack;
    private int size = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void Push(int x) {
        if (size < stack.Length) {
            stack[size++] = x;
        }
    }
    
    public int Pop() {
        if (size < 1) return -1;
        return stack[--size];
    }
    
    public void Increment(int k, int val) {
        int lim = Math.Min(k, size);
        for (int i = 0; i < lim; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * obj.Increment(k,val);
 */
