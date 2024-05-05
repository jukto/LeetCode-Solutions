class Solution {
    public boolean isAnagram(String s, String t) {
        int[] target = new int[123];

        for (char c : t.toCharArray()) target[c]++;
        for (char c : s.toCharArray()) target[c]--;

        for (int i = 'a'; i <= 'z'; i++) {
            if(target[i] != 0) return false;
        }

        return true;
    }
}
