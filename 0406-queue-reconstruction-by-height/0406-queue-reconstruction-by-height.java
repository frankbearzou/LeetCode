class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort by height, is height same, sort by k
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.get(i);
        }
        return people;
    }
}