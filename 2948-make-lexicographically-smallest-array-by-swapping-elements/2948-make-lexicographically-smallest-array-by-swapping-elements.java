class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, Deque<Integer>> groupToNums = new HashMap<>();
        int group = 0;
        numToGroup.put(arr[0], group);
        groupToNums.put(group, new ArrayDeque<>());
        groupToNums.get(group).add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > limit)
                group++;
            numToGroup.put(arr[i], group);
            groupToNums.computeIfAbsent(group, k -> new ArrayDeque<>()).add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            int g = numToGroup.get(nums[i]);
            nums[i] = groupToNums.get(g).remove();
        }
        return nums;
    }
}