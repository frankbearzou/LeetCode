class Solution {
    int max = 0;
    int[] box = new int[46];

    public int countBalls(int lowLimit, int highLimit) {
        for (int i = lowLimit; i <= highLimit; i++) {
            put(i);
        }
        return max;
    }

    void put(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        max = Math.max(max, ++box[sum]);
    }
}