class Solution {
    public int countSegments(String s) {
        int segments = 0, space = 1;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                space = 1;
            } else {
                segments += space;
                space = 0;
            }
        }
        
        return segments;
    }
}
