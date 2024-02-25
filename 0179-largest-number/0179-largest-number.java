class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }
        int k = 0;
        while (k < ans.length() - 1 && ans.charAt(k) == '0') {
            k++;
        }
        return ans.substring(k);
    }
}