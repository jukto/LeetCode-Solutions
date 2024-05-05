class Solution {
    public int compress(char[] chars) {
        int length = 0;

        for (int i = 0; i < chars.length; i++) {
            chars[length] = chars[i];
            length++;
            if (i < chars.length - 1 && chars[i + 1] == chars[i]) {
                char current = chars[i];
                int j = i - 1;
                i++;
                while(i < chars.length - 1 && chars[i + 1] == current) { i++; }
                for (char c : Integer.toString(i - j).toCharArray()) {
                    chars[length] = c;
                    length++;
                }
            }
        }
        
        return length;
    }
}
