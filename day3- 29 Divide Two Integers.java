class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (out of bounds, return 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both to negative to prevent overflow issues
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Shift divisor left until it's smaller than a (closer to -infinity)
        while (a <= b) {
            int shift = 0;
            // Prevent bit overflow during shift operations
            while (b >= Integer.MIN_VALUE >> 1 && a <= (b << 1)) {
                b <<= 1;
                shift++;
            }
            
            // Subtract the shifted divisor from a
            a -= b;
            // Add the corresponding power of 2 to the quotient
            quotient += (1 << shift);
            
            // Reset b back to the original divisor value for the next iteration
            b = divisor < 0 ? divisor : -divisor;
        }

        return isNegative ? -quotient : quotient;
    }
}
