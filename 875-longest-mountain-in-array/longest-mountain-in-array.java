class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 1; i < n - 1; i++) {
            // check if current index is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = lcheck(arr, i);
                int right = rcheck(arr, i);
                int len = right - left + 1;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // move leftwards while strictly increasing
    public int lcheck(int[] arr, int peak) {
        int left = peak;
        while (left > 0 && arr[left - 1] < arr[left]) {
            left--;
        }
        return left;
    }

    // move rightwards while strictly decreasing
    public int rcheck(int[] arr, int peak) {
        int right = peak;
        while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
            right++;
        }
        return right;
    }
}
