class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        int[] freq = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0, required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0; // To store the beginning of the best window

        while (right < s.length()) {
            char r = s.charAt(right);

            // If this character is part of t
            if (freq[r] > 0) {
                required--; // one needed char found
            }
            freq[r]--; // decrease freq (could go negative if extra)

            // When we have a valid window
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Shrink window from left
                char l = s.charAt(left);
                freq[l]++;
                if (freq[l] > 0) { 
                    // This means we removed a needed char
                    required++;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
