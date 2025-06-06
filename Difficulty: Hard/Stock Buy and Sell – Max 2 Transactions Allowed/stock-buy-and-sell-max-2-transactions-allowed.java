//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
       int n=prices.length;
        int mpist=0;
        int leastsf=prices[0];
        int dpl[]=new int[n];
        for(int i=1;i<n;i++){
            if(prices[i]<leastsf){
                leastsf=prices[i];
            }
            mpist=prices[i]-leastsf;
            if(mpist>dpl[i-1]){
                dpl[i]=mpist;
            }
            else{
                dpl[i]=dpl[i-1];
            }
        }
        int mpibt=0;
        int maxat=prices[n-1];
        int dpr[]=new int[n];
        for(int i=n-2;i>=0;i--){
            if(prices[i]>maxat){
                maxat=prices[i];
            }
            mpibt=maxat-prices[i];
            if(mpibt>dpr[i+1]){
                dpr[i]=mpibt;
            }
            else{
                dpr[i]=dpr[i+1];
            }
            
        }
        int op=0;
        for(int i=0;i<n;i++){
            if(dpl[i]+dpr[i] > op){
                op=dpl[i]+dpr[i];
            }
        }
        return op;  
    }
}
