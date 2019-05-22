class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (q1.peek() != null)
            q2.add(q1.remove());
        q1.add(x);
        while (q2.peek() != null)
            q1.add(q2.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.peek() != null)
            return q1.remove();
        return -1;
    }
    
    /** Get the top element. */
    public int top() {
        if (q1.peek() != null)
            return q1.peek();
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
