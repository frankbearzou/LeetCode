class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder str = new StringBuilder();
        int r = 0, c = 0;
        for (char ch : target.toCharArray()) {
            int d = (int)(ch - 'a');
            int dr = d / 5;
            int dc = d % 5;
            
            while (r > dr) {
                str.append("U");
                r--;
            }
            while (c > dc) {
                str.append("L");
                c--;
            }
            while (r < dr) {
                str.append("D");
                r++;
            }
            while (c < dc) {
                str.append("R");
                c++;
            }
            str.append("!");
        }
        return str.toString();
    }
}