class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2001];
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            map[num + 1000]++;
        }
        for (int count : map) {
            if (count > 0) {
                if (set.contains(count))
                    return false;
                set.add(count);
            }
        }
        return true;
    }
}