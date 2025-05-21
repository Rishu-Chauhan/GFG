class Solution {
    public int kthSmallest(int m, int n, int k) {
        // code here
        int left = 1, right = m * n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(mid, m, n);
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left; 
    }
     private int getCount(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }
}