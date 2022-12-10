class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;
  
        for(int i=0; i<n; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            twoSum(nums, i, n, list);
        }
        return list;
    }

    public void twoSum(int[] nums, int i, int n, List<List<Integer>> list) {
        int low = i+1;
        int high = n-1;
        while(low<high) {
            int sum = nums[i]+nums[low]+nums[high];
            if(sum==0) {
                list.add(Arrays.asList(nums[i], nums[low], nums[high--]));
                while(low<high && nums[high]==nums[high+1]) 
                    high--;
            } else if(sum>0) {
                high--;
            } else {
                low++;
            }
        }
    }
}