class Solution {
    public int largestVariance(String s) {
        Set<Character> charSet = new HashSet<Character>();
        char[] sArray = s.toCharArray();
        for (char c : sArray) charSet.add(c);
        Character[] letters = new Character[charSet.size()];
        charSet.toArray(letters);
        int maxVariance = 0, lettersLength = letters.length;

        for (int a = 1; a < lettersLength; a++) {
            char charA = letters[a];
            for (int b = 0; b < a; b++) {
                char charB = letters[b];

                int varianceAB = 0, varianceBA = 0;
                boolean containsA = false, containsB = false, startsWithA = false, startsWithB = false;

                for (char charI : sArray) {
                    if (charI == charA) {
                        varianceAB++;

                        containsA = true;
                        if (startsWithA && varianceBA >= 0) {
                            startsWithA = false;
                        } else if (--varianceBA < 0) {
                            startsWithA = true;
                            varianceBA = -1;
                        }

                        if (containsB && varianceAB > maxVariance) maxVariance = varianceAB;
                        if (varianceBA > maxVariance) maxVariance = varianceBA;
                    } else if (charI == charB) {
                        varianceBA++;

                        containsB = true;
                        if (startsWithB && varianceAB >= 0) {
                            startsWithB = false;
                        } else if (--varianceAB < 0) {
                            startsWithB = true;
                            varianceAB = -1;
                        }

                        if (varianceAB > maxVariance) maxVariance = varianceAB;
                        if (containsA && varianceBA > maxVariance) maxVariance = varianceBA;
                    }
                }
            }
        }
        return maxVariance;
    }
}
