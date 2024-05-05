class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int j = 0, n = asteroids.length;

        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                int k = i + 1;

                while (true) {
                    if (k >= n || asteroids[k] > 0) {
                        if (i > j) {
                            asteroids[j] = asteroid;
                        }
                        j++;
                        break;
                    }

                    if (-asteroids[k] >= asteroid) {
                        if (-asteroids[k] == asteroid) { k++; }
                        break;
                    }

                    k++;
                }
                i = k - 1;

            } else {
                j--;

                while (true) {
                    if (j < 0 || asteroids[j] < 0) {
                        j++;
                        if (i > j) {
                            asteroids[j] = asteroid;
                        }
                        break;
                    }
                    
                    if (-asteroids[j] <= asteroid) {
                        if (-asteroids[j] == asteroid) { j--; }
                        break;
                    }

                    j--;
                }
                j++;
            }
        }
        
        return Arrays.copyOf(asteroids, j);
    }
}
