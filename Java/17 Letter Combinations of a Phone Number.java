//  Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        return backtracking(new ArrayList<String>(), digits.toCharArray(), 0, new char[digits.length()]);
    }

    // A simple dfs backtracking solution. One thing of note: since we know the final length of every member
    // of the result will be equal to the length of the input, we can use a fixed-length char array to store the
    // running value as opposed to a String or StringBuilder.
    private List<String> backtracking(List<String> out, char[] digits, int index, char[] run) {
        if (digits.length == index) {
            out.add(new String(run));
        } else {
            for (char c : letters.get(digits[index])) {
                run[index] = c;
                backtracking(out, digits, index + 1, run);
            }
        }
        return out;
    }

    private static final Map<Character, char[]> letters = new HashMap<>();
    static {
        letters.put('2', new char[] { 'a', 'b', 'c' });
        letters.put('3', new char[] { 'd', 'e', 'f' });
        letters.put('4', new char[] { 'g', 'h', 'i' });
        letters.put('5', new char[] { 'j', 'k', 'l' });
        letters.put('6', new char[] { 'm', 'n', 'o' });
        letters.put('7', new char[] { 'p', 'q', 'r', 's' });
        letters.put('8', new char[] { 't', 'u', 'v' });
        letters.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }
}
