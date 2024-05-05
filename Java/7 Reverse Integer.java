class Solution {
    public int reverse(int x) {
        int result = 0;
        
        if (x < 0) {
            while (x != 0) {
                if (result < -214748364) return 0;
                result *= 10;
                result += x % 10;
                x /= 10;
            }
        } else {
            while (x != 0) {
                if (result > 214748364) return 0;
                result *= 10;
                result += x % 10;
                x /= 10;
            }
        }
        
        return result;
    }
}
