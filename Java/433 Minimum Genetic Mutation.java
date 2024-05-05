class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Gene[] geneBank = new Gene[bank.length];
        for (int i = 0; i < geneBank.length; i++) {
            geneBank[i] = new Gene(bank[i]);
        }
        return recursion(new Gene(startGene), new HashSet<Gene>(bank.length), geneBank, new Gene(endGene));
    }

    private int recursion(Gene current, Set<Gene> used, Gene[] geneBank, Gene goal) {
        int min = 10;
        for (Gene mut : geneBank) {
            if (!used.contains(mut) && isValidMutation(current, mut)) {
                if (mut.hash == goal.hash) { return 1; }
                used.add(mut);
                int temp = recursion(mut, used, geneBank, goal);
                used.remove(mut);
                if (temp < min && temp != -1) {
                    min = temp;
                }
            }
        }
        if (min >= 10) { return -1; }
        return min + 1;
    }

    private boolean isValidMutation(Gene gene1, Gene gene2) {
        boolean differences = false;

        for(int i = 0; i < 8; i++) {
            if (gene1.code[i] != gene2.code[i]) {
                if (differences) {
                    return false;
                }
                differences = true;
            }
        }

        return differences;
    }

    private class Gene {
        public char[] code;
        public int hash;

        public Gene(String g) {
            code = g.toCharArray();
            hash = g.hashCode();
        }
    }
}
