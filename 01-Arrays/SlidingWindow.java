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

    // Day 4
    // 3. Longest substring with at most k distinct characters
    static int longestKDistinct(String s, int k)
    {
        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);

            // If more than k distinct charas, shrink window
            while(map.size() > k)
            {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1); 
        }
        return maxLen;
    }

    // 4. Longest Subarray with sum at most k
    static int longestSum(int[] arr, int k)
    {
        int left = 0, sum = 0, maxLen = 0;
        for(int right = 0; right < arr.length; right++)
        {
            sum += arr[right];
            while(sum > k)
            {
                sum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println("Max sum subarray of size " + k1 + ": " +maxSumSubarray(arr1, k1));

        int[] arr2 = {12, -1, -7, 8, 15, 30, 16, 28};
        int k2 = 3;
        System.out.println("First negatives in each window: " + firstNegativeInWindow(arr2, k2));

        String s = "eceba";
        int kDistinct = 2;
        System.out.println("Longest substring with at most " + kDistinct + " distinct: " + longestKDistinct(s, kDistinct));

        int[] arr3 = {4, 2, 1, 1, 1, 2, 3};
        int maxSumK = 5;
        System.out.println("Longest subarray with sum at most " + maxSumK + ": " + longestSum(arr3, maxSumK));
    }
}
