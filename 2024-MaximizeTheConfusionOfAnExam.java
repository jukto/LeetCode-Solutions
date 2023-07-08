class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxLength = 0;
        int startIndexT = 0, startIndexF = 0;
        int fCount = 0, tCount = 0;

        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'T') {
                if (tCount < k) {
                    tCount++;
                } else {
                    while (answerKey.charAt(startIndexF) == 'F') { startIndexF++; }
                    startIndexF++;
                }
            } else {
                if (fCount < k) {
                    fCount++;
                } else {
                    while (answerKey.charAt(startIndexT) == 'T') { startIndexT++; }
                    startIndexT++;
                }
            }

            int lengthT = i - startIndexT + 1;
            int lengthF = i - startIndexF + 1;

            if (lengthT > maxLength) maxLength = lengthT;
            if (lengthF > maxLength) maxLength = lengthF;
        }

        return maxLength;
    }
}
