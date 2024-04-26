class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        int[] arr = new int[100001];
        for (int cost : costs)
            arr[cost]++;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (i > coins)
                    return count;
                while (arr[i] > 0 && i <= coins) {
                    coins -= i;
                    arr[i]--;
                    count++;
                }
            }
        }
        return count;
    }
}