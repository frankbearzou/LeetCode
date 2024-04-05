class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] num = new int[num_people];
        int i = 1;
        while (candies > 0) {
            int candy = Math.min(i, candies);
            num[(i - 1) % num_people] += candy;
            candies -= candy;
            i++;
        }
        return num;
    }
}