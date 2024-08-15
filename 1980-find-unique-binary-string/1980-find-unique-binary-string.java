class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String num : nums)
            set.add(num);
        int max = (int)Math.pow(2, n);
        for (int i = 0; i < max; i++) {
            String s = toStr(i, n);
            if (!set.contains(s))
                return s;
        }
        return "";
    }

    String toStr(int i, int n) {
        String s = "";
        while (i > 0) {
            s = "" + (i & 1) + s;
            i >>= 1;
        }
        while (s.length() < n) {
            s = "0" + s;
        }
        return s;
    }
}