class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        if (n <= 2) return ans;
        
        int[] adjacentPrefix = new int[n - 1];
        
        // for each adjacent pair, check prefix length
        for (int i = 0; i < words.length - 1; i++) {
            adjacentPrefix[i] = checkPrefixLen(words[i], words[i + 1]);
        }

        int[] prefixMax = new int[n - 1];
        int[] suffixMax = new int[n - 1];

        prefixMax[0] = adjacentPrefix[0];
        for (int i = 1; i < n - 1; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], adjacentPrefix[i]);
        }

        suffixMax[n - 2] = adjacentPrefix[n - 2];
        for (int i = n- 3; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], adjacentPrefix[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = suffixMax[1]; 
            } else if (i == n - 1) {
                ans[i] = prefixMax[n - 3]; 
            } else {
                int left = (i - 2 >= 0) ? prefixMax[i - 2] : 0;
                int right = (i + 1 < n - 1) ? suffixMax[i + 1] : 0;
                int merged = checkPrefixLen(words[i - 1], words[i + 1]);
                ans[i] = Math.max(merged, Math.max(left, right));
            }
        }

        return ans;
    }

    private int checkPrefixLen(String s1, String s2) {
        int currPrefixLen = 0;

        int len = Math.min(s1.length(), s2.length());
        while (currPrefixLen < len) {
            if (s1.charAt(currPrefixLen) == s2.charAt(currPrefixLen)) {
                currPrefixLen++;
            } else {
                break;
            }
        }
        return currPrefixLen;
    }
}