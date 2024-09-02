class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i : chalk)
            sum += i;
        k = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i])
                return i;
            k -= chalk[i];
        }
        return 0;
    }
}