class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
        
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }
        
        return arr;
    }
}
