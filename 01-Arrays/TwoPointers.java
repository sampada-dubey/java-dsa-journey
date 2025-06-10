import java.util.*;

public class TwoPointers
{
    // 1. Pair with target sum in sorted array
    static boolean pairWithTargetSum(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            int sum = arr[left] + arr[right];
            if(sum == target) return true;
            else if(sum < target) left++;
            else right--;
        }
        return false;
    }  
    
    // 2. Trapping Rainwater
    static int trapRainWater(int[] height)
    {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, trapped = 0;

        while(left < right)
        {
            if(height[left] <= height[right])
            {
                if(height[left] >= leftMax) leftMax = height[left];
                else trapped += leftMax - height[left];
                left++;
            }
            else
            {
                if(height[right] >= rightMax) rightMax = height[right];
                else trapped += rightMax - height[right];
                right--;
            }
        }
        return trapped;
    }
    // 3. Remove Duplicates from Sorted Array (in-place)
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; // Length of unique elements
    }

    // 4. Container With Most Water
    static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args)
    {
        // 1️. Test pair with target sum
        int[] arr1 = {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println("Pair with target sum exists: " + pairWithTargetSum(arr1, target));

        // 2️. Test trapping rainwater
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped rainwater: " + trapRainWater(height));

        // 3. Remove Duplicates from Sorted Array
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(nums);
        System.out.println("Length of unique elements: " + length);

        // 4. Container With Most Water
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max Area: " + maxArea(heights));
    }
}