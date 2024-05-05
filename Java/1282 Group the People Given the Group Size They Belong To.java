//  Problem: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.get(size);

            if (list == null) {
                list = new ArrayList<>();
                map.put(size, list);
            }

            list.add(i);
        }

        for (int i : map.keySet()) {
            var list = map.get(i);

            if (list.size() == i) {
                result.add(list);
            } else {
                for (int k = 0; k < list.size(); k += i) {
                    result.add(list.subList(k, k + i));
                }
            }
        }

        return result;
    }
}
