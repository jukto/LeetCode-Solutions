//  Problem: https://leetcode.com/problems/reconstruct-itinerary/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // Init map to contain a sorted collection (PriorityQueue) of each destination reachable from map[s].
        for (var ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            PriorityQueue<String> q = map.get(from);

            if (q == null) {
                q = new PriorityQueue<String>();
                map.put(from, q);
            }

            q.add(to);
        }

        return recursion(map, new LinkedList<>(), "JFK");
    }

    LinkedList<String> recursion(Map<String, PriorityQueue<String>> map, LinkedList<String> result, String from) {
        var pq = map.get(from);

        if (pq != null) {
            while (!pq.isEmpty()) {
                recursion(map, result, pq.poll());
            }
        }
        
        result.addFirst(from);

        return result;
    }
}
