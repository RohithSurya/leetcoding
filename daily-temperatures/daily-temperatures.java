class Solution {
    // public int[] dailyTemperatures(int[] temperatures) {
    //     Stack<Integer> stack = new Stack<>();
    //     int[] answers = new int[temperatures.length];
    //     for(int i=0;i<temperatures.length;i++) {
    //         int curr = temperatures[i];
    //         while(!stack.isEmpty() && curr>temperatures[stack.peek()]) {
    //             int top = stack.pop();
    //             answers[top] = i-top;
    //         }
    //         stack.push(i);
    //     }
    //     return answers;
    // }
    
    public int[] dailyTemperatures(int[] temperatures) {
        int hottest = 0, currentTemp,days;
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            currentTemp = temperatures[i];
            if(currentTemp>=hottest) {
                hottest = currentTemp;
                continue;
            }
            days = 1;
            while(temperatures[i+days]<=currentTemp) {
                days+=ans[i+days];
            }
            ans[i]=days;
        }
        return ans;
    }
}