class Solution {
    public boolean judgeCircle(String moves) {
        int[] counts = new int[86];

        for (char c : moves.toCharArray()) {
            counts[c]++;
        }

        return counts['U'] == counts['D'] && counts['L'] == counts['R'];
    }
}
