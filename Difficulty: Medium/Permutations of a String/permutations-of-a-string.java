class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
         ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sorting to handle duplicates
        backtrack(result, new StringBuilder(), new boolean[s.length()], chars);
        return result;
    }
     private void backtrack(ArrayList<String> result, StringBuilder temp, boolean[] used, char[] chars) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) continue; // Skip duplicates
            
            used[i] = true;
            temp.append(chars[i]);
            backtrack(result, temp, used, chars);
            temp.deleteCharAt(temp.length() - 1);
            used[i] = false;
        }
}
}