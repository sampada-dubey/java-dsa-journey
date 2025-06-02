import java.util.*;
public class MonotonicStack
{
    // 1. Next Greater Element
    static int[] nextGreaterElement(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
            {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    // 2. Largest Rectangle in Histogram
    static int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++)
        {
            int curr = (i == n) ? 0: heights[i];
            while (!stack.isEmpty() && curr < heights[stack.peek()])
            {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i -stack.peek() - 1;
                maxArea = Math.max(maxArea,h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args)
    {
        // 1️⃣ Test Next Greater Element
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElement(nums)));

        // 2️⃣ Test Largest Rectangle in Histogram
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
