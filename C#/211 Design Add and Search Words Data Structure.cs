// Problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/

public class WordDictionary {
    private TrieNode root = new();
    
    public void AddWord(string word) {
        root.AddWord(word.ToCharArray(), 0);
    }
    
    public bool Search(string word) {
        return root.ContainsWord(word.ToCharArray(), 0);
    }

    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public bool end = false;

        public bool ContainsWord(char[] word, int i) {
            if (i == word.Length) {
                return end;
            }

            var ch = word[i];
            if (ch == '.') {

                foreach (var child in children) {
                    if (child != null && child.ContainsWord(word, i + 1)) {
                        return true;
                    }
                }
                return false;

            } else {
                if (children[ch - 'a'] == null) {
                    return false;
                }
                return children[ch - 'a'].ContainsWord(word, i + 1);
            }
        }

        public void AddWord(char[] word, int i) {
            if (i == word.Length) {
                end = true;
                return;
            }

            var ch = word[i];

            if (children[ch - 'a'] == null) {
                children[ch - 'a'] = new();
            }

            children[ch - 'a'].AddWord(word, i + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */
