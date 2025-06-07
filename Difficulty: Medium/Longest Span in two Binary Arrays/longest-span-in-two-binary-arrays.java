
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
         int n = a1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
 
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
               
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}