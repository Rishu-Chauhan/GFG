class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // Code here
        
     ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length(), n = txt.length();
        
        int[] lps = computeLPSArray(pat, m); // Compute longest prefix suffix array
        
        int i = 0, j = 0; 
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) { 
                result.add(i - j + 1); // 1-based indexing
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return result;
    }
     private int[] computeLPSArray(String pat, int m) {
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
}
}