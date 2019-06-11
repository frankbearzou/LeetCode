class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] split = text.split(" ");
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second))
                list.add(split[i + 2]);
        }
        return list.toArray(new String[0]);
    }
}
