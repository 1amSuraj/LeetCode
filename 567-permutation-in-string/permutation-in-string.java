class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count frequency of s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int window = s1.length();

        // First window in s2
        for (int i = 0; i < window; i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (matches(s1Count, s2Count)) return true;

        // Slide the window
        for (int i = window; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++; // add new char
            s2Count[s2.charAt(i - window) - 'a']--; // remove old char

            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}
