class Solution {
    public boolean checkIfPangram(String sentence) {
        // Quick check: a pangram must have at least 26 characters
        if (sentence.length() < 26) {
            return false;
        }

        // Use a bitmask to track seen letters (26 bits for 'a'-'z')
        int seen = 0;

        for (int i = 0; i < sentence.length(); i++) {
            seen |= (1 << (sentence.charAt(i) - 'a'));
            
            // If all 26 bits are set to 1, we found every letter
            if (seen == (1 << 26) - 1) {
                return true;
            }
        }

        return seen == (1 << 26) - 1;
    }
}
