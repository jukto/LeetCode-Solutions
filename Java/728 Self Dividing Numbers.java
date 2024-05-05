class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        int i = left - 1, num, r;

        outerloop:
        while ((num = ++i) <= right) {
            do {
                if ((r = num % 10) == 0 || i % r != 0)
                    continue outerloop;
            } while ((num /= 10) > 0);
            result.add(i);
        }

        return result;
    }
}
