class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        
        for (int num : nums) {
            if (set.add(num))
                ans.add(num);
            else
                ans.remove(num);
        }
        return ans.iterator().next();
    }
}
