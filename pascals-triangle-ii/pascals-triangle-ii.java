class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        getRows(list, rowIndex, 0);
        return list;
    }
    
    public void getRows(List<Integer> list, int n, int i) {
        if(i>n) return;
        list.add(1);
        for(int j=i-1;j>0;j--) {
            if(j==i || j==0) list.set(j, 1);
            else list.set(j, list.get(j)+list.get(j-1));
        }
        getRows(list, n, i+1);
    }
}