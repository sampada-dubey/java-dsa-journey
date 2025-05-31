import java.util.*;
public class SlidingWindow
{
    // 1. Maximum sum of subarray of size k
    static int maxSumSubarray(int[] arr, int k)
    {
        int maxSum = 0;
        int windowSum = 0;

        // first window
        for(int i = 0; i < k; i++)
        {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // slide the window
        for(int i = k; i < arr.length; i++)
        {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // 2. First negative integer in every window of size k
    static List<Integer> firstNegativeInWindow(int[] arr, int k)
    {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        // first window
        for(int i = k; i < arr.length; i++)
        {
            // remove out-of-window elements
            if(!dq.isEmpty() && dq.peek() <= i - k)
            {
                dq.poll();
            }

            // add current element if negative
            if(arr[i] < 0) dq.add(i);

            // first negative in current window
            res.add(dq.isEmpty() ? 0 : arr[dq.peek()]);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println("Max sum subarray of size " + k1 + ": " +maxSumSubarray(arr1, k1));

        int[] arr2 = {12, -1, -7, 8, 15, 30, 16, 28};
        int k2 = 3;
        System.out.println("First negatives in each window: " + firstNegativeInWindow(arr2, k2));
    }
}
