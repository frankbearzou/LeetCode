class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        
        arr[0] = -n / 2;
        arr[n - 1] = n / 2;
        for (int i = 1; i < n / 2; i++)
            arr[i] = arr[i - 1] + 1;
        for (int i = n - 2; i >= n / 2; i--)
            arr[i] = arr[i + 1] - 1;
        if (n % 2 == 1)
            arr[n / 2] = 0;
        
        return arr;
    }
}
