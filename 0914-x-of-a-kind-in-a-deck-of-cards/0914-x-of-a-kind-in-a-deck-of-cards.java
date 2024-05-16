class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deck)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> values = new ArrayList<>(map.values());
        int g = -1;
        for (int i : map.values()) {
            if (g == -1)
                g = i;
            g = gcd(g, i);
        }
        return g >= 2;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}