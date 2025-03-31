//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        int count=0;
        int lastIdx[]=new int[26];
        for(int i=0;i<s.length();i++){
            int pos=s.charAt(i)-'a';
            lastIdx[pos]=i;
        }
        int range=0;
        for(int i=0;i<s.length();i++){
            range=Math.max(range,lastIdx[s.charAt(i)-'a']);
            if(range==i){
                count++;
            }
        }
        return count;
        }
}