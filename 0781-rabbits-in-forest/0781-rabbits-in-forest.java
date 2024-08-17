class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int ans : answers) {
            if (ans == 0)
                count++;
            else if (!set.contains(ans)) {
                count += ans + 1;
                set.add(ans);
            }
        }
        return count;
    }
}