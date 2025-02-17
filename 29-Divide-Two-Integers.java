class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: division by zero or overflow
        if (divisor == 0) {
            throw new ArithmeticException(\Division by zero\);
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to prevent overflow and take absolute values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long result = 0;

        // Division using bit manipulation
        while (n >= d) {
            long temp = d, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            result += multiple;
        }

        // Apply sign and handle overflow for the result
        result = isNegative ? -result : result;

        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}