class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x = 0, y = 0;
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                x += 1;
            } else if (c == 'S') {
                x -= 1;
            } else if (c == 'E') {
                y += 1;
            } else {
                y -= 1;
            }
            String s = x + "," + y;
            if (set.contains(s))
                return true;
            set.add(s);
        }
        return false;
    }
}