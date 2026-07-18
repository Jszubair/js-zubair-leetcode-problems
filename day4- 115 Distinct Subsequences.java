class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] stores the number of distinct subsequences of s that equal t[0...j-1]
        int[] dp = new int[n + 1];
        
        // Base case: An empty string t has 1 matching subsequence in any prefix of s
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Traverse backwards to use values from the previous row
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        
        return dp[n];
    }
}
