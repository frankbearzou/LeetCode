class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    set.add(i);
                    set.add(num / i);
                }
                if (set.size() > 2)
                    break;
            }
            if (set.size() == 2) {
                sum += 1 + num;
                for (int s : set)
                    sum += s;
            }
        }
        return sum;
    }
}