//  Problem: https://leetcode.com/problems/boats-to-save-people/description/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // init and sort so that k is the index of the lightest un-boated person, and i is the index of the heaviest.
        int k = 0, i = people.length - 1;
        Arrays.sort(people);

        // starting from the heaviest, for each person check if the next lightest can fit with them
        // otherwise give them their own boat
        while (i > k)
            if (people[i--] + people[k] <= limit) k++;

        // the number of boats is the total number of people minus the number of people that rode with someone else
        return people.length - k;
    }
}
