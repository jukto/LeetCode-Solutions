class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<Integer>();
        }

        int[] target = new int[26], window = new int[26];
        List<Integer> result = new ArrayList<Integer>();
        char[] sArray = s.toCharArray();
        int pLength = p.length();

        for (char c : p.toCharArray()) {
            target[c - 97]++;
        }

        for (int i = 0; i < pLength; i++) {
            window[sArray[i] - 97]++;
        }

        if (Arrays.equals(target, window)) {
            result.add(0);
        }
        
        for (int i = 0; i < sArray.length - pLength; i++) {
            window[sArray[i] - 97]--;
            window[sArray[i + pLength] - 97]++;
            if (Arrays.equals(target, window)) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
