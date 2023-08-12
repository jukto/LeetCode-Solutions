//  Problem: https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        var charray = new char[maxWidth];
        int i = 0;

        // Rather than building each line from left to right by appending words and padding,
        // we initialize each line to be a char array (a charray if you will) of maxWidth spaces, and then place the words onto it.
        // This results in more writes to charray, but simplifies the logic for padding.
        while (i < words.length) {
            int lineLength = 0, j = i;
            Arrays.fill(charray, ' ');

            // Fetch as many words as will fit on the line (assuming all but the last have at least one space after them).
            while (i < words.length && lineLength + words[i].length() <= maxWidth)
                lineLength += words[i++].length() + 1;

            int spaces = i - j - 1, next = 0;

            // If the line consists of a single word or contains the final word, it is left padded.
            if (spaces == 0 || i == words.length) {
                for (int k = j; k < i; k++) {
                    for (var c : words[k].toCharArray()) { charray[next++] = c; }
                    next++;
                }

            // Otherwise it is justified.
            } else {
                // pad is the number of spaces between each word (rounded down), the first mod paddings are one longer
                int pad = maxWidth - lineLength + i - j, mod = pad % spaces;
                pad /= spaces;
                
                for (int k = j; k < i - 1; k++) {
                    for (var c : words[k].toCharArray()) { charray[next++] = c; }
                    next += (mod-- > 0) ? pad + 1 : pad;
                }
            }

            result.add(new String(charray));
        }

        return result;
    }
}
