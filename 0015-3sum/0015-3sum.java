class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;
  
        for(int i=0; i<n; i++) {
            if(nums[i]>0) break;
            if(i!=0 && nums[i]==nums[i-1]) continue;
            twoSum(nums, i, n, list);
        }
        return list;
    }

    public void twoSum(int[] nums, int i, int n, List<List<Integer>> list) {
        var low = i+1;
        var hs = new HashSet<Integer>();
        while(low<n) {
            var target = -(nums[low]+nums[i]);
            if(hs.contains(target)) {
                // System.out.println("Came here");
                list.add(Arrays.asList(nums[i], nums[low++], target ));
                while(low<n &&nums[low]==nums[low-1]) low++;
            } else {
                low++;
            }
            hs.add(nums[low-1]);
        }
    }
}