// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        // your code here
         return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }
     private int atMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        
        int count = 0, left = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            
            while (freqMap.size() > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                if (freqMap.get(s.charAt(left)) == 0) {
                    freqMap.remove(s.charAt(left));
                }
                left++;
            }
            
            count += (right - left + 1);
        }
        
        return count;
}
}