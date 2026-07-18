class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (e.g., -121 reversed is 121-)
        // Numbers ending in 0 are not palindromes unless the number itself is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return 0 == 1; // returns false
        }

        int revertedNumber = 0;
        // Reverse digits until we reach the middle of the number
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // For even length numbers, x should equal revertedNumber (e.g., 1221 -> x=12, revertedNumber=12)
        // For odd length numbers, we can get rid of the middle digit by revertedNumber / 10 (e.g., 12321 -> x=12, revertedNumber=123)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
