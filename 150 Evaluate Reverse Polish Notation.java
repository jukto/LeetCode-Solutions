//  Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        // Using an array as a manual stack to save an entire 3ms of execution time.
        int stack[] = new int[tokens.length], index = -1;
        char c;
        
        for (var s : tokens) {
            if (s.length() > 1 || Character.isDigit(c = s.charAt(0)))
                stack[++index] = Integer.valueOf(s);

            else if (c == '*')
                stack[index - 1] *= stack[index--];

            else if (c == '+')
                stack[index - 1] += stack[index--];

            else if (c == '/')
                stack[index - 1] /= stack[index--];

            else
                stack[index - 1] -= stack[index--];
        }

        return stack[0];
    }
}
