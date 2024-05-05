class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Boolean> queue = new LinkedList<Boolean>();
        int R = 0, D = 0, ban = 0;

        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                if (ban <= 0) {
                    R++;
                    queue.add(true);
                }
                ban--;
            } else {
                if (ban >= 0){
                    D++;
                    queue.add(false);
                }
                ban++;
            }
        }
        
        while (D > 0 && R > 0) {
            if (queue.remove()) {
                if (ban > 0) R--;
                else queue.add(true);
                ban--;
            } else {
                if (ban < 0) D--;
                else queue.add(false);
                ban++;
            }
        }

        return queue.peek() ? "Radiant" : "Dire";
    }
}
