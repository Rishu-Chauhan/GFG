class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        HashSet<Integer> set=new HashSet<>();
        int count=0;
        for(int [] row:mat2){
            for(int num:row){
                set.add(num);
            }
        }
         for(int [] row:mat1){
            for(int num:row){
               if(set.contains(x-num)){
                   count++;
               }
            }
        }
       
        return count;
    }
}