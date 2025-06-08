
import java.math.BigInteger;

class Solution {
    public boolean isSumString(String s) {
        // code here
          int n = s.length();
        
        // Try different ways to split the first two numbers
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String first = s.substring(0, i);
                String second = s.substring(i, j);
                
                // Check if the sequence is valid
                if (isValidSumString(s, first, second, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValidSumString(String s, String first, String second, int start) {
        // Leading zero check
        if ((first.length() > 1 && first.charAt(0) == '0') || 
            (second.length() > 1 && second.charAt(0) == '0')) {
            return false;
        }
        
        // Convert to BigInteger
        BigInteger num1 = new BigInteger(first);
        BigInteger num2 = new BigInteger(second);
        
        while (start < s.length()) {
            BigInteger sum = num1.add(num2);
            String sumStr = sum.toString();
            
            // Check if the next part of the string matches the sum
            if (!s.startsWith(sumStr, start)) {
                return false;
            }
            
            // Move forward
            start += sumStr.length();
            num1 = num2;
            num2 = sum;
        }
        
        return true;
    }
}