class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        int ind=0, minIndex=Integer.MAX_VALUE, csum=0;
        for(int i=0; i<list1.length; i++) {
            hm.put(list1[i], i);
        }
        
        for(int i=0; i<list2.length; i++) {
            ind = hm.getOrDefault(list2[i], -1);
            if(ind!=-1) {
                csum = i+ind;
                if(csum<minIndex) {
                    minIndex=csum;
                    result.clear();
                    // System.out.println
                }
                if(csum==minIndex) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
        
    }
}