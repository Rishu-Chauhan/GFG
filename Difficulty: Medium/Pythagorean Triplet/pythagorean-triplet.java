class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        if(arr.length<3){
            return false;
        }
         HashSet<Integer> squares = new HashSet<>();
        for (int num : arr) {
            squares.add(num * num);
        }

     
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sumOfSquares = (arr[i] * arr[i]) + (arr[j] * arr[j]);
                if (squares.contains(sumOfSquares)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}