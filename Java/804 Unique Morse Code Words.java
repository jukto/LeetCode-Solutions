class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<String>();

        for (String word : words) {
            StringBuilder sBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                sBuilder.append(morse[c - 97]);
            }
            set.add(sBuilder.toString());
        }

        return set.size();
    }


    private static String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
}
