class Solution {
    public String toHexspeak(String num) {
        String res = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "O");
        map.put(1, "I");
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        long n = Long.parseLong(num);
        while (n > 0) {
            int remainder = (int)(n % 16);
            if (remainder > 1 && remainder < 10)
                return "ERROR";
            res = map.get(remainder) + res;
            n /= 16;
        }

        return res;
    }
}