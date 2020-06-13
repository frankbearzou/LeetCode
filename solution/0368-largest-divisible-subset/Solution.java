class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, index = -1;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        while (index != -1) {
            ans.add(nums[index]);
            index = pre[index];
        }
        
        return ans;
    }
}
