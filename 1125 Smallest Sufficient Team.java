class Solution {
    private static Map<String, Integer> bitMap = new HashMap<String, Integer>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Person> usefulPeople = new ArrayList<Person>(people.size());
        LinkedList<Team> queue = new LinkedList<Team>();
        
        int bit = 1;
        int bitGoal = 0;

        for (String skill : req_skills) {
            bitMap.put(skill, bit);
            bitGoal |= bit;
            bit <<= 1;
        }

        for (int i = 0; i < people.size(); i++) {
            usefulPeople.add(new Person(i, people.get(i)));
        }

        usefulPeople.sort(new myComparator());
        bit = 1;

        for (int i = 0; i < usefulPeople.size(); i++) {
            var person1 = usefulPeople.get(i);
            person1.peopleBit = bit;
            person1.usefulIndex = i;
            queue.add(new Team(person1));
            for (int k = usefulPeople.size() - 1; k > i; k--) {
                var person2 = usefulPeople.get(k);
                if ((person1.skills & person2.skills) == person2.skills) {
                    usefulPeople.remove(k);
                }
            }
            bit <<= 1;
        }

        while (true) {
            var team = queue.pop();
            if (team.skills == bitGoal) {
                int j = 0, k = 0;
                
                int[] result = new int[team.size];

                while (team.peopleBits > 0) {
                    if ((team.peopleBits & 1) == 1) {
                        result[j] = usefulPeople.get(k).realIndex;
                        j++;
                    }
                    k++;
                    team.peopleBits >>= 1;
                }

                return result;
            }

            team.size++;

            for (int k = team.lastIndex + 1; k < usefulPeople.size(); k++) {
                var p = usefulPeople.get(k);
                if ((team.skills & p.skills) != p.skills) {
                    queue.add(new Team(team, p));
                }
            }
        }
    }

    private class Person {
        public int skills, skillCount, realIndex, usefulIndex;
        public long peopleBit;

        public Person(int i, List<String> skillList) {
            realIndex = i;
            skillCount = skillList.size();
            for (String skill : skillList) {
                skills |= bitMap.get(skill);
            }
        }
    }

    private class Team {
        public int skills, size, lastIndex;
        public long peopleBits;

        public Team(Person p) {
            skills = p.skills;
            lastIndex = p.usefulIndex;
            peopleBits = p.peopleBit;
            size = 1;
        }

        public Team(Team team, Person p) {
            skills = team.skills | p.skills;
            lastIndex = p.usefulIndex;
            peopleBits = team.peopleBits | p.peopleBit;
            size = team.size;
        }
    }
        
    private class myComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return b.skillCount - a.skillCount;
        }
    }
}
