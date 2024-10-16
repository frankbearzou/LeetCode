class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((first, second) -> second.getValue() - first.getValue());
        if (a > 0)
            queue.add(new Pair('a', a));
        if (b > 0)
            queue.add(new Pair('b', b));
        if (c > 0)
            queue.add(new Pair('c', c));
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair<Character, Integer> pair = queue.remove();
            char ch = pair.getKey();
            int count = pair.getValue();
            if (ans.length() >= 2 && ans.charAt(ans.length() - 1) == ch && ans.charAt(ans.length() - 2) == ch) {
                if (queue.isEmpty())
                    break;
                Pair<Character, Integer> second = queue.remove();
                ans.append(second.getKey());
                if (second.getValue() > 1)
                    queue.add(new Pair(second.getKey(), second.getValue() - 1));
            } else {
                count--;
                ans.append(ch);
            }
            if (count > 0)
                queue.add(new Pair(ch, count));
        }
        return ans.toString();
    }
}