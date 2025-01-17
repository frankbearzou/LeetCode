class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        return fill(derived, 0) || fill(derived, 1);
    }

    boolean fill(int[] derived, int first) {
        int n = derived.length;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] = arr[i] ^ derived[i];
        }
        return derived[n - 1] == (arr[0] ^ arr[n - 1]);
    }
}