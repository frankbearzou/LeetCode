class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            int lena = a.length();
            int lenb = b.length();
            if (lena != lenb)
                return lena - lenb;
            return a.compareTo(b);
        });
        for (String num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.remove();
        }
        return queue.peek();
    }
}