class MyCircularQueue {
    private int[] arr;
    int head = -1, tail = -1;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (isEmpty())
            ++head;
        tail = (tail + 1) % arr.length;
        arr[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (head == tail)
            head = tail = -1;
        else
            head = (head + 1) % arr.length;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (head != -1)
            return arr[head];
        else
            return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (tail != -1)
            return arr[tail];
        else
            return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((tail + 1) % arr.length == head)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
