class Solution {
    public String complexNumberMultiply(String a, String b) {
        // (p+qi)(u+vi)
        int x, y;
        String[] splitA = a.split("\\+");
        int p = Integer.parseInt(splitA[0]);
        int q = Integer.parseInt(splitA[1].substring(0, splitA[1].length() - 1));
        splitA = b.split("\\+");
        int u = Integer.parseInt(splitA[0]);
        int v = Integer.parseInt(splitA[1].substring(0, splitA[1].length() - 1));
        x = p * u - q * v;
        y = p * v + q * u;
        return x + "+" + y + "i";
    }
}
