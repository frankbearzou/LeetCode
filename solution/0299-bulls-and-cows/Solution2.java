class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] a = new int[10];
        int[] b = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                a[secret.charAt(i) - '0']++;
                b[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            B += Math.min(a[i], b[i]);
        }
        return A + "A" + B + "B";
    }
}
