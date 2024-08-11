class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int[] arr = {1, memory1, memory2};
        while (arr[0] <= arr[1] || arr[0] <= arr[2]) {
            if (arr[1] >= arr[2])
                arr[1] -= arr[0];
            else if (arr[2] > arr[1])
                arr[2] -= arr[0];
            arr[0]++;
        }
        return arr;
    }
}