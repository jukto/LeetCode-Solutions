class Solution {
    public int minimumLengthEncoding(String[] words) {
        ArrayList<TrieNode> wordEnds = new ArrayList<TrieNode>(words.length);
        HashSet<String> wordSet = new HashSet<String>(words.length);
        TrieNode root = new TrieNode();
        int result = 0;

        for (String word : words) {
            if (wordSet.add(word)) {
                TrieNode node = root;
                char[] w = word.toCharArray();
                for (int i = w.length - 1; i >= 0; i--) {
                    node = node.get(w[i]);
                }
                node.value = word.length() + 1;
                wordEnds.add(node);
            }
        }

        for (TrieNode node : wordEnds) {
            if (node.isEmpty) result += node.value;
        }

        return result;
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEmpty = true;
        int value;

        public TrieNode get(char c) {
            if (children == null) {
                children = new TrieNode[26];
                children[c - 97] = new TrieNode();
                isEmpty = false;
            } else if (children[c - 97] == null) {
                children[c - 97] = new TrieNode();
                isEmpty = false;
            }
            return children[c - 97];
        }
    }
}
