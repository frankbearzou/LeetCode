class CustomStack {
    private int[] arr;
    private int index;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        index = -1;
    }
    
    public void push(int x) {
        if (index + 1 == maxSize)
            return;
        arr[++index] = x;

    }
    
    public int pop() {
        if (index == -1)
            return index;
        return arr[index--];
    }
    
    public void increment(int k, int val) {
        int end = Math.min(index, k - 1);
        if (end < 0)
            return;
        for (int i = 0; i <= end; i++)
            arr[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */