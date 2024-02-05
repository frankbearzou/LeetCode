class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            String top = queue.poll();
            for (int i = 0; i < top.length(); i++) {
                char[] arr = top.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String s = new String(arr);
                    if (s.equals(endWord))
                        return ans;
                    if (wordSet.contains(s) && !visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}