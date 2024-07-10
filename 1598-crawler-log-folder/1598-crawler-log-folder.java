class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                level = Math.max(0, level - 1);
            } else if ("./".equals(log)) {

            } else {
                level++;
            }
        }
        return level;
    }
}