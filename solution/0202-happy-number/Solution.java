class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (set.add(n)) {
            list.clear();
            while (n != 0) {
                list.add(n % 10);
                n /= 10;
            }
            for (int num : list) {
                n += num * num;
            }
            if (n == 1)
                return true;
        }
        
        return false;
    }
}
