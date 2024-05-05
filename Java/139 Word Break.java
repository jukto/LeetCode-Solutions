class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int minLength = wordDict.get(0).length(), maxLength = wordDict.get(0).length();
        Set<String> wordSet = new HashSet<String>(wordDict.size());

        for (String word : wordDict) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            } else if (word.length() < minLength) {
                minLength = word.length();
            }
            wordSet.add(word);
        }

        return recursion(wordSet, new boolean[s.length() + 1], s, 0, minLength, maxLength);
    }

    private boolean recursion(Set<String> wordSet, boolean[] processed, String s, int index, int minLength, int maxLength) {
        processed[index] = true;
        for (int i = Math.min(index + maxLength + 1, s.length()); i >= index + minLength; i--) {
            if (!processed[i] && wordSet.contains(s.substring(index, i))) {
                if (i == s.length() || recursion(wordSet, processed, s, i, minLength, maxLength)) {
                    return true;
                }
            }
        }
        return false;
    }
}
