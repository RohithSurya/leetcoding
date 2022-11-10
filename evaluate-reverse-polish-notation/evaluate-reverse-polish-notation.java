class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String string;
        int n = tokens.length;
        int right, left;
        for(int i=0; i<n; i++) {
            string = tokens[i];
            if(string.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (string.equals("-")) {
                right=stack.pop();
                left=stack.pop();
                stack.push(left-right);
            } else if(string.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if(string.equals("/")) {
                right=stack.pop();
                left=stack.pop();
                stack.push(left/right);
            } else {
                stack.push(Integer.parseInt(string));
            }
        }
        return stack.pop();
    }
}