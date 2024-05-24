// Problem: https://leetcode.com/problems/maximum-score-words-formed-by-letters/

public class Solution {
    public int MaxScoreWords(string[] wordStrings, char[] letters, int[] score) {
        var words = new Word[wordStrings.Length];
        var pool = new int[26];

        for (int i = 0; i < wordStrings.Length; i++) {
            words[i] = new(wordStrings[i], score);
        }

        foreach (var c in letters) {
            pool[c - 'a']++;
        }
        

        return DFS(words, 0, pool);
    }

    private int DFS(Word[] words, int index, int[] pool) {
        if (index == words.Length) return 0;

        var word = words[index];
        int take = 0, skip = 0;

        if (word.TryRemove(pool)) {
            take = word.score + DFS(words, index + 1, pool);
            word.AddTo(pool);
        }
        skip = DFS(words, index + 1, pool);

        return Math.Max(take, skip);
    }

    public class Word {
        public readonly int[] letters = new int[26];
        public readonly int score = 0;

        public Word(string word, int[] scores) {
            foreach (var c in word) {
                letters[c - 'a']++;
                score += scores[c - 'a'];
            }
        }

        public bool TryRemove(int[] pool) {
            for (int i = 0; i < 26; i++) {
                if (pool[i] < letters[i]) {
                    return false;
                }
            }
            for (int i = 0; i < 26; i++) {
                pool[i] -= letters[i];
            }
            return true;
        }

        public void AddTo(int[] available) {
            for (int i = 0; i < 26; i++) {
                available[i] += letters[i];
            }
        }
    }
}
