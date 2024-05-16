class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        Set<Integer> aliceSet = new HashSet<>();
        Set<Integer> bobSet = new HashSet<>();
        for (int i : aliceSizes) {
            aliceSum += i;
            aliceSet.add(i);
        }
        for (int i : bobSizes) {
            bobSum += i;
            bobSet.add(i);
        }
        int half = (aliceSum + bobSum) / 2;
        for (int a : aliceSet) {
            int bob = half - aliceSum + a;
            if (bobSet.contains(bob))
                return new int[]{a, bob};
        }
        return new int[0];
    }
}