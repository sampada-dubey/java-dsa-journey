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

    public static void main(String[] args)
    {
        // 1️. Test pair with target sum
        int[] arr1 = {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println("Pair with target sum exists: " + pairWithTargetSum(arr1, target));

        // 2️. Test trapping rainwater
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped rainwater: " + trapRainWater(height));
    }
}