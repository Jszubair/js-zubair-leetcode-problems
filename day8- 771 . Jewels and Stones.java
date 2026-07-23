import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Store all jewel types in a HashSet for O(1) lookup time
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        
        // Count how many stones are present in the jewel set
        int jewelCount = 0;
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                jewelCount++;
            }
        }
        
        return jewelCount;
    }
}
