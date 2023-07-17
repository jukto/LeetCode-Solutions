class Solution {
    private static final int e_ = 4, f_ = 5, g_ = 6, h_ = 7, i_ = 8, n_ = 13, o_ = 14, r_ = 17, s_ = 18, t_ = 19, u_ = 20, v_ = 21, w_ = 22, x_ = 23, z_ = 25;

    public String originalDigits(String s) {
        StringBuilder result = new StringBuilder(s.length() >> 1);
        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 97]++;
        }
        
        letters[s_] -= letters[x_];
        letters[v_] -= letters[s_];

        for (int i = letters[z_]; i > 0; i--) {
            result.append('0');
        }
        for (int i = letters[o_] - letters[z_] - letters[w_] - letters[u_]; i > 0; i--) {
            result.append('1');
        }
        for (int i = letters[w_]; i > 0; i--) {
            result.append('2');
        }
        for (int i = letters[h_] - letters[g_]; i > 0; i--) {
            result.append('3');
        }
        for (int i = letters[u_]; i > 0; i--) {
            result.append('4');
        }
        for (int i = letters[v_]; i > 0; i--) {
            result.append('5');
        }
        for (int i = letters[x_]; i > 0; i--) {
            result.append('6');
        }
        for (int i = letters[s_]; i > 0; i--) {
            result.append('7');
        }
        for (int i = letters[g_]; i > 0; i--) {
            result.append('8');
        }
        for (int i = letters[i_] - letters[v_] - letters[x_] - letters[g_]; i > 0; i--) {
            result.append('9');
        }

        return result.toString();
    }
}
