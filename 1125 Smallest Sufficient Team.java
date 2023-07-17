class Solution {
    private static int[] runningResult;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Person> usefulPeople = new ArrayList<Person>(people.size());
        PriorityQueue<Person> peopleHeap = new PriorityQueue<Person>( (a, b) -> b.skillCount - a.skillCount );
        Map<String, Integer> skillToBitMap = new HashMap<String, Integer>(req_skills.length);
        int bit = 1, skillGoal = 0;
        runningResult = null;

        for (String skill : req_skills) {
            skillToBitMap.put(skill, bit);
            skillGoal |= bit;
            bit <<= 1;
        }

        for (int i = 0; i < people.size(); i++) {
            List<String> skillList = people.get(i);
            int skills = 0;

            for (String skill : skillList) {
                skills |= skillToBitMap.get(skill);
            }
            
            peopleHeap.add(new Person(i, skills, skillList.size()));
        }

        outerloop:
        do {
            Person person1 = peopleHeap.poll();
            for (Person person2 : usefulPeople) {
                if ((person1.skills & person2.skills) == person1.skills) {
                    continue outerloop;
                }
            }
            usefulPeople.add(person1);
        } while (!peopleHeap.isEmpty());

        recursion(usefulPeople, skillGoal, new ArrayList<Person>(usefulPeople.size()), 0, -1);
        return runningResult;
    }


    private void recursion(List<Person> usefulPeople, int skillGoal, List<Person> runningTeam, int runningSkills, int lastIndex) {
        if (runningResult != null && runningResult.length <= runningTeam.size()) {
            return;
        }

        if (runningSkills == skillGoal) {
            if (runningResult == null || runningResult.length > runningTeam.size()) {
                runningResult = new int[runningTeam.size()];
                for (int i = 0; i < runningTeam.size(); i++) {
                    runningResult[i] = runningTeam.get(i).realIndex;
                }
            }
            return;
        }
        
        for (int i = lastIndex + 1; i < usefulPeople.size(); i++) {
            Person p = usefulPeople.get(i);
            if ((runningSkills & p.skills) != p.skills) {
                runningTeam.add(p);
                recursion(usefulPeople, skillGoal, runningTeam, runningSkills | p.skills, i);
                runningTeam.remove(runningTeam.size() - 1);
            }
        }
    }

    private class Person {
        public int skills, skillCount, realIndex;

        public Person(int realIndex, int skills, int skillCount) {
            this.realIndex = realIndex;
            this.skills = skills;
            this.skillCount = skillCount;
        }
    }
}
