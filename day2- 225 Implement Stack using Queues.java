import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Pushes element x to the top of the stack.
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        
        // Rotate the queue to bring the newly added element to the front
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    // Removes the element on the top of the stack and returns it.
    public int pop() {
        return queue.remove();
    }
    
    // Returns the element on the top of the stack.
    public int top() {
        return queue.peek();
    }
    
    // Returns true if the stack is empty, false otherwise.
    public boolean empty() {
        return queue.isEmpty();
    }
}
