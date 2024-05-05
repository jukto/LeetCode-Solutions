//  Problem: https://leetcode.com/problems/excel-sheet-column-title/

class Solution {
    public String convertToTitle(int columnNumber) {
        var result = new StringBuilder();

        // Basically a conversion from base 10 to base 26.
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                result.append('Z');
                columnNumber--;
            } else {
                result.append((char)(columnNumber % 26 + 64));
            }
            
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}
