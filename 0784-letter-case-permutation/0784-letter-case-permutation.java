class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                continue;
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                char[] arr = poll.toCharArray();
                arr[i] = Character.toLowerCase(arr[i]);
                queue.offer(String.valueOf(arr));
                arr[i] = Character.toUpperCase(arr[i]);
                queue.offer(String.valueOf(arr));
            }
        }
        return new ArrayList(queue);
    }
}