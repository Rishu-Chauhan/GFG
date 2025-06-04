// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
          if (e == 0) return 1.0;  // Any number raised to 0 is 1
        double half = power(b, e / 2);
        
        if (e % 2 == 0) {
            return half * half;
        } else {
            return (e > 0) ? half * half * b : half * half / b;  // Handle negative exponents
        }
       
    }
}