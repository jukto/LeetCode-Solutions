class Solution {
    public int romanToInt(String s) {
        int value = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'I') {
                value++;
            } else if (c == 'V') {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    value += 4;
                    i--;
                } else {
                    value += 5;
                }
            } else if (c == 'X') {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    value += 9;
                    i--;
                } else {
                    value += 10;
                }
            } else if (c == 'L') {
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    value += 40;
                    i--;
                } else {
                    value += 50;
                }
            } else if (c == 'C') {
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    value += 90;
                    i--;
                } else {
                    value += 100;
                }
            } else if (c == 'D') {
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    value += 400;
                    i--;
                } else {
                    value += 500;
                }
            } else if (c == 'M') {
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    value += 900;
                    i--;
                } else {
                    value += 1000;
                }
            }
        }

        return value;
    }
}
