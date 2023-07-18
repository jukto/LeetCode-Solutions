class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (i % 3 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Buzz");
                }
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
