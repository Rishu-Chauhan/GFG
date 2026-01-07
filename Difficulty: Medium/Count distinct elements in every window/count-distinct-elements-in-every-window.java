class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> list =new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int n=arr.length;
     
        int j=0;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(i-j+1==k){
                list.add(map.size());
                map.put(arr[j],map.get(arr[j])-1);
                if(map.get(arr[j])==0){
                    map.remove(arr[j]);
                }
                j++;
            }
        }
        return list;
    }
}