class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        if(k==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
             
             while(map.size()>k){
                 map.put(arr[left],map.get(arr[left])-1);
                 if(map.get(arr[left])==0){
                     map.remove(arr[left]);
                 }
                 left++;
             }
             res +=(i-left+1);
        }
        return res;
    }
}
