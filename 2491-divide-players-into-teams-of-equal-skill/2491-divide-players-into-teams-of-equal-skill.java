class Solution {
    public long dividePlayers(int[] skill) {
        long ans = 0;
        Arrays.sort(skill);
        long sum = 0;
        int n = skill.length;
        for (int s : skill)
            sum += s;
        if (sum % (n / 2) != 0)
            return -1;
        long avg = sum / (n / 2);
        int l = 0, r = n - 1;
        while (l < r) {
            long s = skill[l] + skill[r];
            if (s != avg)
                return -1;
            ans += skill[l] * skill[r];
            l++;
            r--;
        }
        return ans;
    }
}