class Solution {
    public int myAtoi(String s) {
        int index = 0;
        long result = 0;
        boolean negative = false;

        while (index < s.length() && s.charAt(index) == ' ') index++;

        if (index < s.length() && s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') index++;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            if (result > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            result *= 10;
            result += s.charAt(index) - 48;
            index++;
        }

        if (negative) {
            result = -result;
            if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int)result;
    }
}
