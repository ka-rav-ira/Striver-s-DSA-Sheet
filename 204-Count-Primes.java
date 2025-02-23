import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        // Call the sieve function to get an array of prime statuses
        boolean[] isPrime = sv(n);

        // Count the number of primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public boolean[] sv(int n) {
        // Create a boolean array to mark prime numbers
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // Mark 0 and 1 as non-prime
        if (n > 0) isPrime[0] = false;
        if (n > 1) isPrime[1] = false;

        // Implement Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}