class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != getPair(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private char getPair(char c) {
        if (c == ')') return '(';
        if (c == '}') return '{';
        return '[';
    }
}
