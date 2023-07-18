class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
        Set<String> wordSet = new HashSet<String>(wordDict.size());
        List<String> result = new ArrayList<String>();

        for (String word : wordDict) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            if (word.length() < minLength) {
                minLength = word.length();
            }
            wordSet.add(word);
        }

        recursion(result, wordSet, new StringBuilder(), s, 0, minLength, maxLength);
        return result;
    }

    private void recursion(List<String> result, Set<String> wordSet, StringBuilder sentence, String s, int index, int minLength, int maxLength) {
        if (index == s.length()) {
            result.add(sentence.toString());
            return;
        }
        int baseSize = sentence.length();
        for (int i = index + minLength; i <= s.length() && i - index <= maxLength; i++) {
            String word = s.substring(index, i);
            if (wordSet.contains(word)) {
                if (sentence.length() > 0) {
                    sentence.append(' ');
                }
                sentence.append(word);
                recursion(result, wordSet, sentence, s, i, minLength, maxLength);
                sentence.setLength(baseSize);
            }
        }
    }
}
