class Solution {
    public String nearestPalindromic(String n) {
        long nn = Long.parseLong(n);
        int len = n.length();
        int half = (len - 1) / 2;
        boolean even = (len % 2) == 0;
        long firstHalf = Long.parseLong(n.substring(0, half + 1));
        List<Long> list = new ArrayList<>();
        list.add(build(firstHalf, even));
        list.add(build(firstHalf + 1, even));
        list.add(build(firstHalf - 1, even));
        list.add((long)Math.pow(10, len) + 1);
        list.add((long)Math.pow(10, len - 1) - 1);

        long diff = Long.MAX_VALUE;
        long res = 0;
        for (long l : list) {
            if (l == nn)
                continue;
            if (Math.abs(l - nn) < diff) {
                diff = Math.abs(l - nn);
                res = l;
            } else if (Math.abs(l - nn) == diff) {
                res = Math.min(res, l);
            }
        }
        return String.valueOf(res);
    }

    long build(long firstHalf, boolean even) {
        long res = firstHalf;
        if (!even)
            firstHalf = firstHalf / 10;
        while (firstHalf > 0) {
            res = res * 10 + firstHalf % 10;
            firstHalf /= 10;
        }
        return res;
    }
}