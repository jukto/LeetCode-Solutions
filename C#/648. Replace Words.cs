// Problem: https://leetcode.com/problems/replace-words/

public class Solution {
    public string ReplaceWords(IList<string> dictionary, string sentence) {
        int min = int.MaxValue, max = 0;
        var split = sentence.Split(' ');
        var trie = new Trie();

        foreach (var word in dictionary) {
            min = Math.Min(min, word.Length);
            max = Math.Max(max, word.Length);
            trie.Add(word, 0);
        }

        for (int i = 0; i < split.Length; i++) {
            for (int k = min; k <= max && k < split[i].Length; k++) {
                if (trie.Contains(split[i], 0, k)) {
                    split[i] = split[i].Substring(0, k);
                    break;
                }
            }
        }

        return string.Join(" ", split);
    }

    public class Trie {
        private Trie[] next = new Trie[26];
        public bool end = false;

        public void Add(string word, int index) {
            if (word.Length == index) {
                end = true;
                return;
            }
            int i = word[index] - 'a';

            if (next[i] == null) {
                next[i] = new Trie();
            }
            next[i].Add(word, index + 1);
        }

        public bool Contains(string word, int index, int last) {
            if (last == index) return end;
            int i = word[index] - 'a';

            if (next[i] == null) return false;
            return next[i].Contains(word, index + 1, last);
        }
    }
}
