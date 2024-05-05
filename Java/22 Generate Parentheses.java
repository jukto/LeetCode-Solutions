class Solution {
    public List<String> generateParenthesis(int n) {
        return recursion(new ArrayList<String>(), new StringBuilder("("), n, 1, 0);
    }

    private List<String> recursion(List<String> result, StringBuilder s, int n, int open, int close) {
        if (n == open) {
            while (close < open) {
                s.append(')');
                close++;
            }
            result.add(s.toString());
            return result;
        }
        if (open > close) recursion(result, new StringBuilder(s).append(')'), n, open, close + 1);
        return recursion(result, s.append('('), n, open + 1, close);
    }
}
