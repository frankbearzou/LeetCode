class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return people;
        
        // sort from taller to shorter, and insert insert to list at position k
        Arrays.sort(people, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] a : people)
            list.add(a[1], a);
        for (int i = 0; i < people.length; i++)
            people[i] = list.get(i);
        return people;
    }
}
