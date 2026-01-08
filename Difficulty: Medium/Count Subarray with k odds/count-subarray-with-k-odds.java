class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        return atMost(arr,k)-atMost(arr,k-1);
    }
    private int atMost(int arr[],int k){
        int left=0,countOdd=0,res=0;
        for(int right=0;right<arr.length;right++){
            if(arr[right] % 2 ==1){
                countOdd++;
            }
            while(countOdd>k){
                if(arr[left] % 2==1){
                    countOdd--;
                }
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }
}
