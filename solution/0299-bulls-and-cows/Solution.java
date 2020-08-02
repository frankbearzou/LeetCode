class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        StringBuilder p = new StringBuilder(secret);
        StringBuilder q = new StringBuilder(guess);
        int[] a = new int[10];
        int[] b = new int[10];
        int index = 0;
        
        while (index < p.length()) {
            if (p.charAt(index) == q.charAt(index)) {
                p.deleteCharAt(index);
                q.deleteCharAt(index);
                A++;
            } else {
                a[p.charAt(index) - '0']++;
                b[q.charAt(index) - '0']++;
                index++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            B += Math.min(a[i], b[i]);
        }
        return A + "A" + B + "B";
    }
}
