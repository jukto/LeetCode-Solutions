class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int i1 = 0, i2 = 0, n1 = w1.length, n2 = w2.length;
        StringBuilder sBuilder = new StringBuilder(n1 + n2);

        while (i1 < n1 && i1 < n2) {
            sBuilder.append(w1[i1]);
            sBuilder.append(w2[i1]);
            i1++;
        }
        i2 = i1;

        while (i1 < n1) {
            sBuilder.append(w1[i1]);
            i1++;
        }

        while (i2 < n2) {
            sBuilder.append(w2[i2]);
            i2++;
        }

        return sBuilder.toString();
    }
}
