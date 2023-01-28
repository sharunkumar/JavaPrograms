package com.sharunkumar;

public class LongestSubarrayaEqualsK {
    public static int longestSubarrayEqualK(int[] a, int k) {
        int n = a.length;
        int start = 0;
        int end = 0;
        int curr_sum = 0;
        int max_len = 0;
        while (end < n) {
            curr_sum += a[end];
            while (curr_sum > k && start < end) {
                curr_sum -= a[start];
                start++;
            }
            if (curr_sum == k) {
                max_len = Math.max(max_len, end - start + 1);
            }
            end++;
        }
        return max_len;
    }


    public static void main(String[] args) {
        System.out.println(longestSubarrayEqualK(new int[]{1, 2, 3}, 3));
    }
}