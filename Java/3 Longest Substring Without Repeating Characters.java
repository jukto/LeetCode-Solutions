class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexes = new HashMap<Character, Integer>();

        int maxLength = 0, runningStart = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (charIndexes.containsKey(c)) {
                while (s.charAt(runningStart) != c) {
                    if (charIndexes.getOrDefault(s.charAt(runningStart), -1) == runningStart) {
                        charIndexes.remove(s.charAt(runningStart));
                        runningStart++;
                    }
                }
                runningStart++;
            }
            
            charIndexes.put(c, i);

            int length = (i + 1) - runningStart;
            if (length > maxLength) {
                maxLength = length;
                temp = runningStart;
            }
        }

        return maxLength;
    }
}
