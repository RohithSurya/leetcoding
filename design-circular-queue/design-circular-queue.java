class MyCircularQueue {
    
    int[] q;
    int front, rear;
    int k;

    public MyCircularQueue(int k) {
        this.k = k;
        q=new int[k];
        front=rear=-1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(front==-1)
            front=rear=0;
        else
            rear=(rear+1)%k;
        q[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        if(front==rear)
            front=rear=-1;
        else
            front=(front+1)%k;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%k==front)
            return true;
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