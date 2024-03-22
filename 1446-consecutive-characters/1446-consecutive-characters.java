class Solution {
    public int maxPower(String s) {
        int max = 1;
        int cur = 1;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i])
                max = Math.max(max, ++cur);
            else
                cur = 1;
        }
        return max;
    }
}