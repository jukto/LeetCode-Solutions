// Problem: https://leetcode.com/problems/path-crossing/

public class Solution {
    public bool IsPathCrossing(string path) {
        var visited = new HashSet<(int, int)>() { (0, 0) };
        int x = 0, y = 0;

        foreach (var c in path) {
            if (c == 'N') y++;
            else if (c == 'E') x++;
            else if (c == 'S') y--;
            else x--;

            if (!visited.Add((y, x))) {
                return true;
            }
        }

        return false;
    }
}
