class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];

        // subtract frequencies of s1
        for (char c : s1.toCharArray()) {
            count[c - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int idx = s2.charAt(right) - 'a';
            count[idx]++;

            // if count[idx] > 0, it means s2 has extra of this char
            while (count[idx] > 0) {
                count[s2.charAt(left) - 'a']--;
                left++;
            }

            // window length matches s1 → valid permutation
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
