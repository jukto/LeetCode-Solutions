class Solution {
    public List<List<String>> partition(String s) {
        return recursivePartition(new ArrayList<List<String>>(), new ArrayList<String>(), s.toCharArray(), 0);
    }

    private List<List<String>> recursivePartition(List<List<String>> result, List<String> runningList, char[] s, int left) {
        for (int i = left + 1; i < s.length; i++) {
            if (isPalindrome(s, left, i)) {
                var list = new ArrayList<String>(runningList);
                list.add(String.copyValueOf(s, left, i - left));
                recursivePartition(result, list, s, i);
            }
        }

        if (isPalindrome(s, left, s.length)) {
            runningList.add(String.copyValueOf(s, left, s.length - left));
            result.add(runningList);
        }

        return result;
    }

    private static boolean isPalindrome(char[] s, int left, int right) {
        return (right - left < 2) ||
            s[left] == s[right - 1] &&  isPalindrome(s, left + 1, right - 1);
    }
}
