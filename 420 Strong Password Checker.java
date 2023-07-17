class Solution {
    public int strongPasswordChecker(String password) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        boolean lowercase = false, uppercase = false, digit = false;
        int inserts = 0, deletes = 0, streak = 0, breaks = 0;
        char last = 0;

        if(password.length() > 20) {
            deletes = password.length() - 20;
        } else if(password.length() < 6) {
            inserts = 6 - password.length();
        }

        for(char c : password.toCharArray()) {
            if ('a' <= c && c <= 'z') lowercase = true;
            else if ('A' <= c && c <= 'Z') uppercase = true;
            else if ('0' <= c && c <= '9') digit = true;

            if (c == last) {
                streak++;
            } else {
                if (streak > 2) {
                    minHeap.add(streak % 3 + 1);
                    breaks += (streak / 3) - 1;
                }
                last = c;
                streak = 1;
            }
        }

        if (streak > 2) {
            minHeap.add(streak % 3 + 1);
            breaks += (streak / 3) - 1;
        }

        int deletesUnused = deletes;

        while (minHeap.size() > 0 && deletesUnused >= minHeap.peek()) {
            deletesUnused -= minHeap.remove();
        }

        breaks -= deletesUnused / 3;

        breaks += minHeap.size();

        int insertsUnused = inserts;

        if (!lowercase)
            if (insertsUnused > 0)
                insertsUnused--;
            else
                inserts++;
            
        if (!uppercase)
            if (insertsUnused > 0)
                insertsUnused--;
            else
                inserts++;
        
        if (!digit)
            if (insertsUnused > 0)
                insertsUnused--;
            else
                inserts++;

        breaks = Math.max(0, breaks - inserts);

        return inserts + deletes + breaks;
    }
}
