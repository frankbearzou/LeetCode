class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] ans = new int[deck.length];
        LinkedList<Integer> index = new LinkedList<>();
        
        for (int i = 0; i < deck.length; i++)
            index.add(i);
        
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }
        
        return ans;
    }
}
