// Problem: https://leetcode.com/problems/maximum-binary-string-after-change/

public class Solution {
    public string MaximumBinaryString(string binary) {
        int zeros = 0, firstZero = binary.IndexOf('0');

        for (int i = 0; i < binary.Length; i++){
            if (binary[i] == '0') {
                zeros++;
            }
        }

        if (zeros < 2) {
            return binary;
        }

        return "0".PadLeft(firstZero + zeros, '1').PadRight(binary.Length, '1');
    }
}
