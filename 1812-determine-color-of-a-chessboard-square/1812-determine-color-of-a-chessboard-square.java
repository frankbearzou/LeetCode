class Solution {
    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(0) - 'a';
        int col = coordinates.charAt(1) - '1';
        return ((row % 2 == 0) && (col % 2 == 1)) || ((row % 2 == 1) && (col % 2 == 0));
    }
}