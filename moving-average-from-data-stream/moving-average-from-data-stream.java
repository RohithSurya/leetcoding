class MovingAverage {
    
    Queue<Integer> q;
    int sum=0;
    int size;

    public MovingAverage(int size) {
        this.size=size;
        q= new LinkedList<>();
    }
    
    public double next(int val) {
        q.offer(val);
        sum+=val;
        if(q.size()>size) {
            sum-=q.poll();
        }
        return sum/(double)q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */