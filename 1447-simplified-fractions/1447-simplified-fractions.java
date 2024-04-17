class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (!isGcd(j, i))
                    res.add(j + "/" + i);
            }
        }
        return res;
    }

    boolean isGcd(int a, int b) {
        for (int i = 2; i <= Math.min(a, b); i++) {
            if ((a % i == 0) && (b % i == 0))
                return true;
        }
        return false;
    }
}