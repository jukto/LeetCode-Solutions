//  Problem: https://leetcode.com/problems/repeated-dna-sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>(), result = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String seq = s.substring(i, i + 10);
            if (!set.add(seq)) {
                result.add(seq);
            }
        }
        
        return new ArrayList<String>(result);
    }
}
