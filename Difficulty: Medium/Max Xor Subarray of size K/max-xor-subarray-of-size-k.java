class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(k>n){
            return  -1;
        }
        int xor=0;
        for(int i=0;i<k;i++){
            xor ^=arr[i];
        }
        int maxXor=xor;
        for(int i=k;i<n;i++){
            xor ^=arr[i-k];
            xor ^=arr[i];
             maxXor=Math.max(maxXor,xor);
        }
       
        return maxXor;
    }
}
