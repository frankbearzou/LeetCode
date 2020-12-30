class Solution {
    public String interpret(String command) {
        String s = command.replaceAll("\\(al\\)", "al");
        s = s.replaceAll("\\(\\)", "o");
        return s;
    }
}
