int hammingWeight(uint32_t n) {
        int sum=0;
        while(n>0) {
            sum+=(n&1);
            n=n/2;
        }
        return sum;
}