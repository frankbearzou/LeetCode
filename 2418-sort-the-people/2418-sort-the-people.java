class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        People[] people = new People[n];
        for (int i = 0; i < n; i++) {
            people[i] = new People(names[i], heights[i]);
        }
        Arrays.sort(people, (a, b) -> b.height - a.height);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = people[i].name;
        }
        return ans;
    }
}

class People {
    String name;
    int height;
    People(String name, int height) {
        this.name = name;
        this.height = height;
    }
}