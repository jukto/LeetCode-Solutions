class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuilder sb = new StringBuilder(s);

            for (int i = s.length() - 1; i > 0; i--) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                String rotation = sb.toString();
                if (rotation.compareTo(s) < 0) {
                    s = rotation;
                }
            }

            return s;
        }

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return String.valueOf(sArray);
    }
}
