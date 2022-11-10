
class Node {
    int value;
    int min;
    
    public Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class MinStack {
    
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(stack.empty()) {
            min = val;
        } else {
            min= Math.min(getMin(), val);
        }
        Node node = new Node(val, min);
        stack.push(node);
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */