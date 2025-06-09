class Solution {
  public:
    int countStrings(string &s) {
        // code here
         int n = s.length();
        
        map<int,int> mp;
        
        for(int i=0;i<n;i++){
            mp[s[i]]++;
        }
        
        long long res = 0;
        
        for(int i=0;i<n;i++){
            res += (n-mp[s[i]]);
        }
        
        res = res/2;
        
        for(auto x:mp){
            if(x.second >= 2){
                res++;
                break;
            }
        }
        return res;
    }
};
