class Solution {
    static final long MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;

        while (n > 1) {
            long nextACount = (eCount + iCount + uCount) % MOD;
            long nextICount = (eCount + oCount) % MOD;

            eCount = (aCount + iCount) % MOD;
            uCount = (iCount + oCount) % MOD;
            oCount = iCount;

            aCount = nextACount;
            iCount = nextICount;

            n--;
        }

        return (int)((aCount + eCount + iCount + oCount + uCount) % MOD);
    }
}
