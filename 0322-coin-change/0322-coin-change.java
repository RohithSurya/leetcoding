class Solution {
    public int coinChange(int[] coins, int amount) {
        coins = Arrays.stream(coins)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
        int[] min = new int[amount+1];
        for(int i=0; i<=amount; i++) min[i]=-2;
        return coinChangeSub(coins, min, amount);
    }
    public int coinChangeSub(int[] coins, int[] min, int amount) {
        // System.out.println(amount);
        if(amount<0) return -1;
        if(amount==0) return 0;
        if(min[amount]!=-2) return min[amount];
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            int count = coinChangeSub(coins, min, amount-coins[i]);
            if(count>=0) minCount = Math.min(minCount, count);
        }
        if(minCount!=Integer.MAX_VALUE) {
            min[amount]=minCount+1;
        } else {
            min[amount]=-1;
        }
        return min[amount];
    }
}