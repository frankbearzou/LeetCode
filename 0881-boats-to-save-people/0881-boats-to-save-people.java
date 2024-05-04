class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int n = people.length, l = 0, r = n - 1;
        Arrays.sort(people);
        while (l <= r) {
            int sum = people[l] + people[r];
            if (sum <= limit) {
                l++;
            }
            r--;
            count++;
        }
        return count;
    }
}