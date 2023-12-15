class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            n = getNumber(n);
        }
        return true;
    }

    int getNumber(int n) {
        int sum = 0;
        while (n != 0) {
            int ones = n % 10;
            sum += ones * ones;
            n = n / 10;
        }
        return sum;
    }
}