class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int post = -1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = post;
            post = Math.max(post, arr[i]);
        }
        return res;
    }
}