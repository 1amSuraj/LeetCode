class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        if (n <= 1) return res;

        int[] lcp = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            lcp[i] = lcpLen(words[i], words[i + 1]);
        }

        int[] pre = new int[n - 1];
        int[] suf = new int[n - 1];

        pre[0] = lcp[0];
        for (int i = 1; i < n - 1; i++) {
            pre[i] = Math.max(pre[i - 1], lcp[i]);
        }

        suf[n - 2] = lcp[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], lcp[i]);
        }

        for (int i = 0; i < n; i++) {
            int best = 0;
            if (i - 2 >= 0) best = Math.max(best, pre[i - 2]);
            if (i + 1 <= n - 2) best = Math.max(best, suf[i + 1]);
            if (i > 0 && i < n - 1) {
                best = Math.max(best, lcpLen(words[i - 1], words[i + 1]));
            }
            res[i] = best;
        }

        return res;
    }

    public static int lcpLen(String a, String b) {
        int m = Math.min(a.length(), b.length());
        int i = 0;
        while (i < m && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }
}