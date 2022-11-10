class Solution {
    public void duplicateZeros(int[] arr) {
        int i=0, shiftEl=0;
        while(shiftEl<arr.length) {
            shiftEl+=arr[i]==0?2:1;
            i++;
        }
        i--;
        while(i>=0) {
            if(arr[i]==0) {
                for(int j=0;j<2;j++) {
                    if(shiftEl>arr.length) {
                        shiftEl--;
                        continue;
                    }
                    arr[--shiftEl]=arr[i];
                }
            } else {
                arr[--shiftEl]=arr[i];
            }
            i--;
        }
    }
}