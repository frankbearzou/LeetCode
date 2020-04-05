class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int k = i;
            boolean dividing = true;
            do {
                if (k % 10 == 0) {
                    dividing = false;
                    break;
                }
                if (i % (k % 10) == 0) {
                    k /= 10;
                } else {
                    dividing = false;
                    break;
                }
            } while (k != 0);
            if (dividing)
                list.add(i);
        }
        return list;
    }
}
