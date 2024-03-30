class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1])
                count++;
        }
        return count;
    }
}