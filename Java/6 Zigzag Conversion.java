class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder(s.length());
        int cycle = numRows == 1 ? 1 : numRows * 2 - 2;

        for (int i = 0; i < numRows; i++) {
            int k = i;
            while (k < s.length()) {
                result.append(s.charAt(k));
                if (i > 0 && i < numRows - 1) {
                    int zag = k + cycle - (i * 2);
                    if (zag < s.length()) result.append(s.charAt(zag));
                }
                k += cycle;
            }
        }

        return result.toString();
    }
}
