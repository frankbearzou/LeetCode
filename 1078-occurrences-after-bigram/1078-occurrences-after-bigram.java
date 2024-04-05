class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] split = text.split(" ");
        for (int i = 0; i + 2 < split.length; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second))
                res.add(split[i + 2]);
        }
        return res.toArray(new String[0]);
    }
}