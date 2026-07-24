import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each English letter 'a'-'z' to its corresponding row index (0, 1, or 2)
        int[] charRow = new int[26];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        for (int row = 0; row < rows.length; row++) {
            for (char c : rows[row].toCharArray()) {
                charRow[c - 'a'] = row;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = charRow[lower.charAt(0) - 'a'];
            boolean isValid = true;
            
            for (int i = 1; i < lower.length(); i++) {
                if (charRow[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
